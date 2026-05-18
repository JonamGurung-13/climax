package com.icp.climax.dao.interfaces;

import com.icp.climax.model.User;

import java.sql.SQLException;
import java.time.LocalDate;

public interface UserDAOInterface {

    //Create New User
    int insertUser(String name, String email, String phoneNumber, String password, LocalDate dateOfBirth);

    //Get User
    User getUser(String email);
}
