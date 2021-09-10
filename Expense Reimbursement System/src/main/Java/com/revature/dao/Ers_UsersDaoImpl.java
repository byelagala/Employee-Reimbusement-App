package com.revature.dao;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;

import java.sql.*;
import java.util.List;

public class Ers_UsersDaoImpl implements Ers_UsersDao{

    //singleton object
    private static Ers_UsersDao ers_usersDao;

    //constructor for
    private Ers_UsersDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //checking with singleton object, below code is guaranty for one instance for UserDao
    public static Ers_UsersDao getInstance(){
        if(ers_usersDao == null){
            ers_usersDao = new Ers_UsersDaoImpl();
        }
        return ers_usersDao;
    }

    @Override
    public void insertUser(Ers_Users ers_users) {
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){
            String sql = "INSERT into ers_users values(default, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setString(1, ers_users.getErsUserName());
            ps.setString(2,ers_users.getErsPassword());
            ps.setString(3,ers_users.getUserFirstName());
            ps.setString(4,ers_users.getUserLastName());
            ps.setString(5,ers_users.getUserEmail());
            ps.setInt(6, ers_users.getUserRoleId_Fk());

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ers_Users getOneUser(String ersUserName) {
        Ers_Users user= null;
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM ers_users WHERE ers_username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ersUserName);

            //this is wh
            ResultSet rs = ps.executeQuery();
            //this is iterating through the records
            while(rs.next()) {
                user = new Ers_Users(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}


