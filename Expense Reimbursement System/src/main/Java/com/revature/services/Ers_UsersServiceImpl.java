package com.revature.services;

import com.revature.dao.Ers_UsersDao;
import com.revature.dao.Ers_UsersDaoImpl;
import com.revature.models.Ers_Users;

public class Ers_UsersServiceImpl implements Ers_UsersService{
    Ers_UsersDao ers_usersDao;

    public Ers_UsersServiceImpl(){
        ers_usersDao = Ers_UsersDaoImpl.getInstance();
    }

    //this constructor used for Mockito testing reference object
    public Ers_UsersServiceImpl(Ers_UsersDao ers_usersDao){
        this.ers_usersDao = ers_usersDao;
    }

    @Override
    public Ers_Users login(Ers_Users user) {
        //check username exists in system
        Ers_Users tempUser = ers_usersDao.getOneUser(user.getErsUserName());
        if(tempUser == null)
            return null;

        //check if password is incorrect
        if(!tempUser.getErsPassword().equals(user.getErsPassword()))
            return null;

        return tempUser;

    }
    @Override
    public Ers_Users register(Ers_Users ers_users) {
        //check if username exists in the system
        Ers_Users tempUser = ers_usersDao.getOneUser(ers_users.getErsUserName());
        //checking
        if(tempUser != null)
            return null;
        //insert user
        ers_usersDao.insertUser(ers_users);
        //returning to ers_usersDao for future login
        return ers_usersDao.getOneUser(ers_users.getErsUserName());
    }
}
