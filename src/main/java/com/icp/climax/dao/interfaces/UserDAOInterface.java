package com.icp.climax.dao.interfaces;

import com.icp.climax.model.User;

import java.sql.SQLException;

public interface UserDAOInterface {

    //Create New User
    int insertUser(String name, String username, String email, String password);

    //Get User
    User getUser(String username);
}
