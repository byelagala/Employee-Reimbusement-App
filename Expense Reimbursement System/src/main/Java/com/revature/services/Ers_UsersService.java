package com.revature.services;

import com.revature.models.Ers_Users;

public interface Ers_UsersService {

    Ers_Users login(Ers_Users user);
    Ers_Users register(Ers_Users ers_users);
}
