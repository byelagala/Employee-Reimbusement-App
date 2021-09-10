package com.revature.models;

public class Ers_User_Roles {

    private Integer ers_user_role_id;
    private String user_role;

    public Ers_User_Roles() {
    }

    public Ers_User_Roles(Integer ers_user_role_id, String user_role) {
        this.ers_user_role_id = ers_user_role_id;
        this.user_role = user_role;
    }

    public Integer getErs_user_role_id() {
        return ers_user_role_id;
    }

    public void setErs_user_role_id(Integer ers_user_role_id) {
        this.ers_user_role_id = ers_user_role_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "Ers_User_Roles{" +
                "ers_user_role_id=" + ers_user_role_id +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}
