package com.icp.climax.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private String profileImage;
    private String approvedStatus;
    private int approvedByAdminId;

    //empty constructor
    public User(){
    }

    //Getters and Setters
    public int getUserId() { return userId;}
    public void setUserId(int userId) { this.userId = userId;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password;}
    public String getPhoneNumber() { return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}
    public LocalDate getDateOfBirth() { return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public LocalDate getDateJoined() { return dateJoined;}
    public void setDateJoined(LocalDate dateJoined) { this.dateJoined = dateJoined;}
    public String getProfileImage() { return profileImage;}
    public void setProfileImage(String profileImage) { this.profileImage = profileImage;}
    public String getApprovedStatus() { return approvedStatus;}
    public void setApprovedStatus(String approvedStatus) { this.approvedStatus = approvedStatus;}
    public int getApprovedByAdminId() { return approvedByAdminId;}
    public void setApprovedByAdminId(int approvedByAdminId) {
        this.approvedByAdminId = approvedByAdminId;
    }
}
