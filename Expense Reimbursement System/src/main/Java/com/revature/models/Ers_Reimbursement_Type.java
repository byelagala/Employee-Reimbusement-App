package com.revature.models;

public class Ers_Reimbursement_Type {

    private Integer reimb_type_id;
    private String reimb_type;

    public Ers_Reimbursement_Type() {
    }

    public Ers_Reimbursement_Type(Integer reimb_type_id, String reimb_type) {
        this.reimb_type_id = reimb_type_id;
        this.reimb_type = reimb_type;
    }

    public Integer getReimb_type_id() {
        return reimb_type_id;
    }

    public void setReimb_type_id(Integer reimb_type_id) {
        this.reimb_type_id = reimb_type_id;
    }

    public String getReimb_type() {
        return reimb_type;
    }

    public void setReimb_type(String reimb_type) {
        this.reimb_type = reimb_type;
    }

    @Override
    public String toString() {
        return "Ers_Reimbursement_Type [reimb_type_id=" + reimb_type_id + ", reimb_type='" + reimb_type + "]";
    }
}
