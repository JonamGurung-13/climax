package com.icp.climax.model;

public class Admin {
    private int adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String contactNumber;

    //empty constructor
    public Admin(){}

    //Getters and Setters
    public void setAdminId(int adminId){this.adminId = adminId;}
    public int getAdminId(){return adminId;}
    public void setAdminName(String adminName){this.adminName = adminName;}
    public String getAdminName(){return adminName;}
    public void setAdminEmail(String adminEmail){this.adminEmail = adminEmail;}
    public String getAdminEmail(){return adminEmail;}
    public void setAdminPassword(String adminPassword){this.adminPassword = adminPassword;}
    public String getAdminPassword(){return adminPassword;}
    public void setContactNumber(String contactNumber){this.contactNumber = contactNumber;}
    public String getContactNumber(){return contactNumber;}
}
