package com.revature.dao;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Reimbursements;

import java.util.List;

public interface Ers_ReimbursementDao {

    public void addReimbursementRequest(Ers_Reimbursement ers_reimbursement);
    public List<Reimbursements> viewAllReimbTicketsByEmpId(Integer ers_users_fk_auth);
    public List<Reimbursements> viewAllReimbursementsByManagerId(Integer ers_users_fk_reslvr);
    public Ers_Reimbursement updateReimbursementRequest(Ers_Reimbursement ers_reimbursement);
    public List<Reimbursements> viewAllEmpReimbursementsByStatus(int ers_users_fk_reslvr,String reimb_status);
    public List<Reimbursements> viewEmpReimbByStatus(int ers_users_fk_auth, String reimb_status);
}
