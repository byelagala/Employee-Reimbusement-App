package com.revature.models;

import java.util.Date;

public class Reimbursements {

    private Integer reimb_id;
    private Integer ers_users_fk_auth;
    private Integer ers_users_fk_rslvr;
    private Double reimb_amount;
    private String reimb_submitted;
    private String reimb_resolved;
    private String reimb_description;
    private String reimb_receipt;
    private  String authorFirstName;
    private String authorLastName;
    private String resolverFirstName;
    private String resolverLastName;
    private String reimb_status;
    private String reimb_type;

    public Reimbursements() {
    }

    public Reimbursements(Integer ers_users_fk_auth, Double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description, String reimb_receipt, String authorFirstName, String authorLastName, String resolverFirstName,
                          String resolverLastName, String reimb_status, String reimb_type) {
        this.ers_users_fk_auth = ers_users_fk_auth;
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.resolverFirstName = resolverFirstName;
        this.resolverLastName = resolverLastName;
        this.reimb_status = reimb_status;
        this.reimb_type = reimb_type;
    }

    public Reimbursements(Integer reimb_id, Integer ers_users_fk_auth, Integer ers_users_fk_rslvr, Double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
                          String reimb_receipt, String authorFirstName, String authorLastName, String resolverFirstName,
                          String resolverLastName, String reimb_status, String reimb_type) {
        this.reimb_id = reimb_id;
        this.ers_users_fk_auth = ers_users_fk_auth;
        this.ers_users_fk_rslvr = ers_users_fk_rslvr;
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.resolverFirstName = resolverFirstName;
        this.resolverLastName = resolverLastName;
        this.reimb_status = reimb_status;
        this.reimb_type = reimb_type;
    }

    public Integer getErs_users_fk_auth() {
        return ers_users_fk_auth;
    }

    public void setErs_users_fk_auth(Integer ers_users_fk_auth) {

        this.ers_users_fk_auth = ers_users_fk_auth;
    }

    public Integer getErs_users_fk_rslvr() {
        return ers_users_fk_rslvr;
    }

    public void setErs_users_fk_rslvr(Integer ers_users_fk_rslvr) {
        this.ers_users_fk_rslvr = ers_users_fk_rslvr;
    }

    public Integer getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(Integer reimb_id) {
        this.reimb_id = reimb_id;
    }

    public Double getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(Double reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    public String getReimb_submitted() {
        return reimb_submitted;
    }

    public void setReimb_submitted(String reimb_submitted) {
        this.reimb_submitted = reimb_submitted;
    }

    public String getReimb_resolved() {
        return reimb_resolved;
    }

    public void setReimb_resolved(String reimb_resolved) {
        this.reimb_resolved = reimb_resolved;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description = reimb_description;
    }

    public String getReimb_receipt() {
        return reimb_receipt;
    }

    public void setReimb_receipt(String reimb_receipt) {
        this.reimb_receipt = reimb_receipt;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getResolverFirstName() {
        return resolverFirstName;
    }

    public void setResolverFirstName(String resolverFirstName) {
        this.resolverFirstName = resolverFirstName;
    }

    public String getResolverLastName() {
        return resolverLastName;
    }

    public void setResolverLastName(String resolverLastName) {
        this.resolverLastName = resolverLastName;
    }

    public String getReimb_status() {
        return reimb_status;
    }

    public void setReimb_status(String reimb_status) {
        this.reimb_status = reimb_status;
    }

    public String getReimb_type() {
        return reimb_type;
    }

    public void setReimb_type(String reimb_type) {
        this.reimb_type = reimb_type;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "reimb_id=" + reimb_id +
                ", ers_users_fk_auth=" + ers_users_fk_auth +
                ", ers_users_fk_rslvr=" + ers_users_fk_rslvr +
                ", reimb_amount=" + reimb_amount +
                ", reimb_submitted=" + reimb_submitted +
                ", reimb_resolved=" + reimb_resolved +
                ", reimb_description='" + reimb_description + '\'' +
                ", reimb_receipt='" + reimb_receipt + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", resolverFirstName='" + resolverFirstName + '\'' +
                ", resolverLastName='" + resolverLastName + '\'' +
                ", reimb_status='" + reimb_status + '\'' +
                ", reimb_type='" + reimb_type + '\'' +
                '}';
    }
}
