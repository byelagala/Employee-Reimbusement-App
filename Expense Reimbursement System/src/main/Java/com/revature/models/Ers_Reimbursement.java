package com.revature.models;

import org.omg.CORBA.portable.InputStream;

import java.security.Timestamp;
import java.util.Date;
import java.security.Timestamp;
import java.util.Date;

public class Ers_Reimbursement extends Reimbursements {

    private Integer reimb_id;
    private Double reimb_amount;
    private String reimb_submitted;
    private String reimb_resolved;
    private String reimb_description;
    private String reimb_receipt;
    private Integer ers_users_fk_auth;
    private Integer ers_users_fk_reslvr;
    private Integer ers_reimbursement_status_fk;
    private Integer ers_reimbursement_type_fk;


    public Ers_Reimbursement() {
    }

    public Ers_Reimbursement(Integer ers_users_fk_auth) {
        this.ers_users_fk_auth = ers_users_fk_auth;
    }

    public Ers_Reimbursement(Integer reimb_id, Double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
                             String reimb_receipt, Integer ers_users_fk_auth, Integer ers_users_fk_reslvr, Integer ers_reimbursement_status_fk, Integer ers_reimbursement_type_fk) {
        this.reimb_id = reimb_id;
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.ers_users_fk_auth = ers_users_fk_auth;
        this.ers_users_fk_reslvr = ers_users_fk_reslvr;
        this.ers_reimbursement_status_fk = ers_reimbursement_status_fk;
        this.ers_reimbursement_type_fk = ers_reimbursement_type_fk;
    }

    public Ers_Reimbursement(Double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description, String reimb_receipt, Integer ers_users_fk_auth,
                             Integer ers_users_fk_reslvr, Integer ers_reimbursement_status_fk, Integer ers_reimbursement_type_fk) {
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.ers_users_fk_auth = ers_users_fk_auth;
        this.ers_users_fk_reslvr = ers_users_fk_reslvr;
        this.ers_reimbursement_status_fk = ers_reimbursement_status_fk;
        this.ers_reimbursement_type_fk = ers_reimbursement_type_fk;
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

    public Integer getErs_users_fk_auth() {
        return ers_users_fk_auth;
    }

    public void setErs_users_fk_auth(Integer ers_users_fk_auth) {
        this.ers_users_fk_auth = ers_users_fk_auth;
    }

    public Integer getErs_users_fk_reslvr() {
        return ers_users_fk_reslvr;
    }

    public void setErs_users_fk_reslvr(Integer ers_users_fk_reslvr) {
        this.ers_users_fk_reslvr = ers_users_fk_reslvr;
    }

    public Integer getErs_reimbursement_status_fk() {
        return ers_reimbursement_status_fk;
    }

    public void setErs_reimbursement_status_fk(Integer ers_reimbursement_status_fk) {
        this.ers_reimbursement_status_fk = ers_reimbursement_status_fk;
    }

    public Integer getErs_reimbursement_type_fk() {
        return ers_reimbursement_type_fk;
    }

    public void setErs_reimbursement_type_fk(Integer ers_reimbursement_type_fk) {
        this.ers_reimbursement_type_fk = ers_reimbursement_type_fk;
    }

    @Override
    public String toString() {
        return "Ers_Reimbursement{" +
                "reimb_id=" + reimb_id +
                ", reimb_amount=" + reimb_amount +
                ", reimb_submitted=" + reimb_submitted +
                ", reimb_resolved=" + reimb_resolved +
                ", reimb_description='" + reimb_description + '\'' +
                ", reimb_receipt='" + reimb_receipt + '\'' +
                ", ers_users_fk_auth=" + ers_users_fk_auth +
                ", ers_users_fk_reslvr=" + ers_users_fk_reslvr +
                ", ers_reimbursement_status_fk=" + ers_reimbursement_status_fk +
                ", ers_reimbursement_type_fk=" + ers_reimbursement_type_fk +
                '}';
    }
}
