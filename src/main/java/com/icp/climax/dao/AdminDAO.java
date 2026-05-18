package com.icp.climax.dao;

import com.icp.climax.dao.interfaces.AdminDAOInterface;
import com.icp.climax.model.Admin;
import com.icp.climax.utilities.DBConfig;

import java.sql.*;

public class AdminDAO implements AdminDAOInterface {

    private Connection connAdmin;
    private boolean isConnectionError = false;

    public AdminDAO(){
        try{
            //Establish connection with the database
            connAdmin = DBConfig.getConnection();
            System.out.println("Connected to database successfully");
            System.out.println("DB Connection" +  connAdmin);
        } catch(SQLException | ClassNotFoundException ex){
            isConnectionError = true;
            System.out.println("DB ERROR" + ex.getLocalizedMessage());
        }
    }

    // 3 represents the error related to Database
    // 2 represents the existence of email and contact number in the admin which must be unique
    // 1 represents success in inserting the admin data
    @Override
    public int insertUser(String adminName, String adminEmail, String adminPassword, String contactNumber) {
        if(isConnectionError){return 3;} //return 3 is there is any error in connection with the DB
        try{
            //Retrieve the existing admin data
            final String CHECK_IF_ADMIN = "SELECT admin_email, contact_number FROM admins WHERE LOWER(admin_email)=LOWER(?) or contact_number=?";
            PreparedStatement preStm = connAdmin.prepareStatement(CHECK_IF_ADMIN);
            preStm.setString(1, adminEmail);
            preStm.setString(2, contactNumber);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                return 2; //return 2 when the email and contact number already exist
            }
            final String INSERT_ADMIN = "INSERT INTO admins (admin_name, admin_email, admin_password, contact_number) VALUES (?, ?, ?, ?)";
            PreparedStatement preStmInsertAdmin = connAdmin.prepareStatement(INSERT_ADMIN);
            preStmInsertAdmin.setString(1, adminName);
            preStmInsertAdmin.setString(2, adminEmail);
            preStmInsertAdmin.setString(3, adminPassword);
            preStmInsertAdmin.setString(4, contactNumber);

            int result = preStmInsertAdmin.executeUpdate();
            return result; // return 1 when a admin row is created


        } catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            return 3;
        }
    }

    @Override
    public Admin getAdmin(String adminEmail) {
        try{
            final String SELECT_ADMIN = "SELECT * FROM admins WHERE LOWER(admin_email) = LOWER(?)";
            PreparedStatement preStmSelectAdmin = connAdmin.prepareStatement(SELECT_ADMIN);
            preStmSelectAdmin.setString(1, adminEmail);
            ResultSet rs = preStmSelectAdmin.executeQuery();
            if(rs.next()){
                final Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setAdminName(rs.getString("admin_name"));
                admin.setAdminEmail(rs.getString("admin_email"));
                admin.setAdminPassword(rs.getString("admin_password"));
                admin.setContactNumber(rs.getString("contact_number"));
                return admin;
            }

        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
