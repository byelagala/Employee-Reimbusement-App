package com.revature.dao;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;

import java.util.List;

public interface Ers_UsersDao {

    //insert new user insert into users table, not returning anything
    void insertUser(Ers_Users ers_users);
    //return the user detail back to user
    Ers_Users getOneUser(String ersUserName);

//    public List<Ers_Reimbursement> viewUserAllPastTickets();
//    public boolean addReimbursementRequest(Ers_Reimbursement ers);
}
