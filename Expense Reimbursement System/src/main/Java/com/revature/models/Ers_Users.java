package com.revature.models;

public class Ers_Users {

    private Integer ersUsersId;
    private String ersUserName;
    private String ersPassword;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private Integer userRoleId_Fk;

    public Ers_Users() {
    }

    public Ers_Users(String ersUserName, String ersPassword) {
        this.ersUserName = ersUserName;
        this.ersPassword = ersPassword;
    }

    public Ers_Users(Integer ersUsersId, String ersUserName, String ersPassword, String userFirstName,
                     String userLastName, String userEmail, Integer userRoleId_Fk) {
        this.ersUsersId = ersUsersId;
        this.ersUserName = ersUserName;
        this.ersPassword = ersPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId_Fk = userRoleId_Fk;
    }

    public Integer getErsUsersId() {
        return ersUsersId;
    }

    public void setErsUsersId(Integer ersUsersId) {
        this.ersUsersId = ersUsersId;
    }

    public String getErsUserName() {
        return ersUserName;
    }

    public void setErsUserName(String ersUserName) {
        this.ersUserName = ersUserName;
    }

    public String getErsPassword() {
        return ersPassword;
    }

    public void setErsPassword(String ersPassword) {
        this.ersPassword = ersPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserRoleId_Fk() {
        return userRoleId_Fk;
    }

    public void setUserRoleId_Fk(Integer userRoleId_Fk) {
        this.userRoleId_Fk = userRoleId_Fk;
    }

    @Override
    public String toString() {
        return "Ers_Users{" +
                "ersUsersId=" + ersUsersId +
                ", ersUserName='" + ersUserName + '\'' +
                ", ersPassword='" + ersPassword + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRoleId_Fk=" + userRoleId_Fk +
                '}';
    }
}
