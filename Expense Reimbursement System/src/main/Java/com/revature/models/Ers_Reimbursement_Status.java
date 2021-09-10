package com.revature.models;

public class Ers_Reimbursement_Status {

    private Integer reimb_status_id;
    private String reimb_status;

    public Ers_Reimbursement_Status() {
    }

    public Ers_Reimbursement_Status(Integer reimb_status_id, String reimb_status) {
        this.reimb_status_id = reimb_status_id;
        this.reimb_status = reimb_status;
    }

    public Integer getReimb_status_id() {
        return reimb_status_id;
    }

    public void setReimb_status_id(Integer reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    public String getReimb_status() {
        return reimb_status;
    }

    public void setReimb_status(String reimb_status) {
        this.reimb_status = reimb_status;
    }

    @Override
    public String toString() {
        return "Ers_Reimbursement_Status{" +
                "reimb_status_id=" + reimb_status_id +
                ", reimb_status='" + reimb_status + '\'' +
                '}';
    }
}
