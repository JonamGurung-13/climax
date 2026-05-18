package com.icp.climax.dao.interfaces;

import com.icp.climax.model.Admin;

public interface AdminDAOInterface {

    //Create New User
    int insertUser(String adminName, String email, String password, String contactNumber);

    //Get Admin
    Admin getAdmin(String adminEmail);
}
