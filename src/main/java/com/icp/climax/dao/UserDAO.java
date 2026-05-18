package com.icp.climax.dao;

import com.icp.climax.dao.interfaces.UserDAOInterface;
import com.icp.climax.model.User;
import com.icp.climax.utilities.DBConfig;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO implements UserDAOInterface {

    private Connection conn;
    private boolean isConnectionError = false;

    public UserDAO() {
        try{
            //Establish connection with the database
            conn = DBConfig.getConnection();
            System.out.println("DB Connection:" + conn);
        } catch (SQLException | ClassNotFoundException ex){
            isConnectionError = true;
            System.out.println("DB ERROR"+ex.getLocalizedMessage());
        }
    }


    @Override
    public int insertUser(String name, String email, String phoneNumber, String password, LocalDate dateOfBirth) {
        if (isConnectionError){return 3;}
        try{
            //Retrieve the existing user data
            final String CHECK_IF_USER = "SELECT email FROM users WHERE  LOWER(email)=LOWER(?)";
            PreparedStatement preStm = conn.prepareStatement(CHECK_IF_USER);
            preStm.setString(1, email);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                return 2; //returns 2 if username and email already exist
            }
            LocalDate currentDate = LocalDate.now();
            String approvedStatus = "Pending";
            final String INSERT_USER = "INSERT INTO users (name,email,phone_number,password,date_of_birth,date_joined,approved_status) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preStm2 = conn.prepareStatement(INSERT_USER);
            preStm2.setString(1,name);
            preStm2.setString(2,email);
            preStm2.setString(3,phoneNumber);
            preStm2.setString(4,password);
            preStm2.setDate(5, Date.valueOf(dateOfBirth));
            preStm2.setDate(6, Date.valueOf(currentDate));
            preStm2.setString(7, approvedStatus);

            int result = preStm2.executeUpdate();
            return result; // return 1 when a user row is created

        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return 3; //returns 3 if any exception occurs
        }
    }

    @Override
    public User getUser(String email) {
        try{
            final String SELECT_USER = "SELECT * FROM users WHERE LOWER(email) = LOWER(?)";
            PreparedStatement preStm = conn.prepareStatement(SELECT_USER);
            preStm.setString(1, email);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                final User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                user.setDateJoined(rs.getDate("date_joined").toLocalDate());
                user.setApprovedStatus(rs.getString("approved_status"));
                user.setProfileImage(rs.getString("profile_image"));
                user.setApprovedByAdminId(rs.getInt("approved_by_admin_id"));

                return user;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
