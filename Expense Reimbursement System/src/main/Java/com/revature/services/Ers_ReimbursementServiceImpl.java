package com.revature.services;

import com.revature.dao.Ers_ReimbursementDao;
import com.revature.dao.Ers_ReimbursementDaoImpl;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Reimbursements;

import java.util.List;

public class Ers_ReimbursementServiceImpl implements Ers_ReimbursementService {

    Ers_ReimbursementDao ers_reimbursementDao;
    //ItemDao itemDao;

    //this constructor used for Mockito testing reference object
    public Ers_ReimbursementServiceImpl(){
        ers_reimbursementDao = Ers_ReimbursementDaoImpl.getInstance();
        //itemDao = ItemDaoImpl.getInstance();
    }

    public Ers_ReimbursementServiceImpl(Ers_ReimbursementDao ers_reimbursementDao){
        this.ers_reimbursementDao = ers_reimbursementDao;
        //itemDao = ItemDaoImpl.getInstance();
    }

    @Override
    public void addReimbursementRequest(Ers_Reimbursement ers_reimbursement) {
        ers_reimbursementDao.addReimbursementRequest(ers_reimbursement);
    }

    @Override
    public List<Reimbursements> viewAllReimbTicketsByEmpId(Integer ers_users_fk_auth) {
        return ers_reimbursementDao.viewAllReimbTicketsByEmpId(ers_users_fk_auth);
    }

    @Override
    public List<Reimbursements> viewAllReimbursementsByManagerId(Integer ers_users_fk_reslvr) {
        return ers_reimbursementDao.viewAllReimbursementsByManagerId(ers_users_fk_reslvr);
    }

    @Override
    public Ers_Reimbursement updateReimbursementRequest(Ers_Reimbursement ers_reimbursement) {
        return ers_reimbursementDao.updateReimbursementRequest(ers_reimbursement);
    }

    @Override
    public List<Reimbursements> viewAllEmpReimbursementsByStatus(int ers_users_fk_reslvr, String reimb_status) {
        return ers_reimbursementDao.viewAllEmpReimbursementsByStatus(ers_users_fk_reslvr,reimb_status);
    }

    @Override
    public List<Reimbursements> viewEmpReimbByStatus(int ers_users_fk_auth,String reimb_status) {
        return ers_reimbursementDao.viewEmpReimbByStatus(ers_users_fk_auth,reimb_status);
    }
}
