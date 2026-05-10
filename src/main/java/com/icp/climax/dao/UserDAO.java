package com.icp.climax.dao;

import com.icp.climax.dao.interfaces.UserDAOInterface;
import com.icp.climax.model.User;
import com.icp.climax.utilities.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public int insertUser(String name, String username, String email, String password) {
        if (isConnectionError){return 3;}
        try{
            //Retrive the existing user name, username, and email
            final String CHECK_IF_USER = "SELECT username, email FROM users WHERE LOWER(username)=LOWER(?) or LOWER(email)=LOWER(?)";
            PreparedStatement preStm = conn.prepareStatement(CHECK_IF_USER);
            preStm.setString(1, username);
            preStm.setString(2, email);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                return 2; //returns 2 if username and email already exist
            }
            final String USER_TYPE = "Customer";
            final String INSERT_USER = "INSERT INTO users (name,username,email,password,user_type) VALUES (?,?,?,?,?)";
            PreparedStatement preStm2 = conn.prepareStatement(INSERT_USER);
            preStm2.setString(1,name);
            preStm2.setString(2,username);
            preStm2.setString(3,email);
            preStm2.setString(4,password);
            preStm2.setString(5,USER_TYPE);

            int result = preStm2.executeUpdate();
            return result; // return 0 or 1 when a user is created

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
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUser_type(rs.getString("user_type"));
                return user;
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
