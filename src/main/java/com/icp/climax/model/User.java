package com.icp.climax.model;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String user_type;

    //empty constructor
    public User(){
    }

    //Getters and Setters
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password;}
    public String getUser_type() { return user_type;}
    public void setUser_type(String user_type) { this.user_type = user_type;}
}
