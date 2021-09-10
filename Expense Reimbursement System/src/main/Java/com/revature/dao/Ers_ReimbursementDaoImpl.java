package com.revature.dao;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Reimbursements;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.security.Timestamp;
//import java.util.Date;
//import java.sql.*;

public class Ers_ReimbursementDaoImpl implements Ers_ReimbursementDao {
    private static Ers_ReimbursementDao ers_reimbursementDao;

    private Ers_ReimbursementDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Ers_ReimbursementDao getInstance() {
        if (ers_reimbursementDao == null)
            ers_reimbursementDao = new Ers_ReimbursementDaoImpl();

        return ers_reimbursementDao;
    }

    //add a new employee Reimbursement
    //localhost:9000/api/ers_reimbursement
    @Override
    public void addReimbursementRequest(Ers_Reimbursement ers_reimbursement) {
        System.out.println("Add a new Employee Reimbursement");

        try (Connection conn = DriverManager.getConnection(ConnectionUtil.url, ConnectionUtil.username, ConnectionUtil.password)) {
            String sql = "INSERT INTO ers_reimbursement VALUES (default, ?, default, default, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setDouble(1, ers_reimbursement.getReimb_amount());
            ps.setString(2, ers_reimbursement.getReimb_description());
            ps.setString(3, ers_reimbursement.getReimb_receipt());
            ps.setInt(4, ers_reimbursement.getErs_users_fk_auth());
            ps.setInt(5, ers_reimbursement.getErs_users_fk_reslvr());
            ps.setInt(6, ers_reimbursement.getErs_reimbursement_status_fk());
            ps.setInt(7, ers_reimbursement.getErs_reimbursement_type_fk());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //view all employee Reimbursements by employee id
    //localhost:9000/api/ers_reimbursement?id=7
    @Override
    public List<Reimbursements> viewAllReimbTicketsByEmpId(Integer ers_users_fk_auth) {
        System.out.println("View all Employee Reimbursements");
        List<Reimbursements> reimbursements = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursements WHERE ers_users_fk_auth = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ers_users_fk_auth);

            //this is wh
            ResultSet rs = ps.executeQuery();

            //this is iterating through the records
            while(rs.next()) {
                reimbursements.add(
                        new Reimbursements(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getString(6), rs.getString(7),
                                rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),
                                rs.getString(13), rs.getString(14))
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }

    //view all Reimbursements by manager Id
    //localhost:9000/api/manager?id=5
    @Override
    public List<Reimbursements> viewAllReimbursementsByManagerId(Integer ers_users_fk_reslvr) {
        System.out.println("View all Manager Reimbursements");
        List<Reimbursements> reimbursements = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursements where ers_users_fk_reslvr=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ers_users_fk_reslvr);

            //this is wh
            ResultSet rs = ps.executeQuery();

            //this is iterating through the records
            while(rs.next()) {
                reimbursements.add(
                        new Reimbursements(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getString(6), rs.getString(7),
                                rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),
                                rs.getString(13), rs.getString(14))
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }

    //Update Reimbursement by manager
    //localhost:9000/api/manager
    @Override
    public Ers_Reimbursement updateReimbursementRequest(Ers_Reimbursement ers_reimbursement) {
        System.out.println("Update Employee Reimbursement by Manager");
        Ers_Reimbursement updated = new Ers_Reimbursement();

        try (Connection conn = DriverManager.getConnection(ConnectionUtil.url, ConnectionUtil.username, ConnectionUtil.password)) {
            String sql = "UPDATE ers_reimbursement SET ers_reimbursement_status_fk = ? , reimb_resolved = now()  where reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setInt(1, ers_reimbursement.getErs_reimbursement_status_fk());
            ps.setInt(2, ers_reimbursement.getReimb_id());

            ps.executeUpdate();

            String view = "SELECT * FROM ers_reimbursement where reimb_id = ?;";
            PreparedStatement ps2 = conn.prepareStatement(view);

            //we need this line to fill the ? input
            ps2.setInt(1, ers_reimbursement.getReimb_id());

            ResultSet rs = ps2.executeQuery();
            if(rs.next()){

                updated.setErs_reimbursement_status_fk(rs.getInt("ers_reimbursement_status_fk"));
                updated.setErs_reimbursement_type_fk(rs.getInt("ers_reimbursement_type_fk"));
                updated.setReimb_amount(rs.getDouble("reimb_amount"));
                updated.setReimb_id(rs.getInt("reimb_id"));
                updated.setErs_users_fk_auth(rs.getInt("ers_users_fk_auth"));
                updated.setErs_users_fk_reslvr(rs.getInt("ers_users_fk_reslvr"));
                updated.setReimb_description(rs.getString("reimb_description"));
                updated.setReimb_receipt(rs.getString("reimb_receipt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }


    //filter all Reimbursements by status
    //localhost:9000/api/reimbursements?reimb_status=Denied
    @Override
    public List<Reimbursements> viewAllEmpReimbursementsByStatus(int ers_users_fk_reslvr, String reimb_status) {
        System.out.println("View all Reimbursements by Status");
        System.out.println(ers_users_fk_reslvr);

        List<Reimbursements> reimbursements = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursements where ers_users_fk_reslvr=? AND reimb_status=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ers_users_fk_reslvr);
            ps.setString(2, reimb_status);

            //this is wh
            ResultSet rs = ps.executeQuery();

            //this is iterating through the records
            while(rs.next()) {
                reimbursements.add(
                        new Reimbursements(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getString(6), rs.getString(7),
                                rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),
                                rs.getString(13), rs.getString(14))
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }

    @Override
    public List<Reimbursements> viewEmpReimbByStatus(int ers_users_fk_auth,String reimb_status) {
        System.out.println("View all Reimbursements by Status");
        System.out.println(ers_users_fk_auth);

        List<Reimbursements> reimbursements = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursements where ers_users_fk_auth =? AND reimb_status=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,ers_users_fk_auth);
            ps.setString(2, reimb_status);

            //this is wh
            ResultSet rs = ps.executeQuery();

            //this is iterating through the records
            while(rs.next()) {
                reimbursements.add(
                        new Reimbursements(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getString(6), rs.getString(7),
                                rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),
                                rs.getString(13), rs.getString(14))
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }
}