package com.revature.models;

public class Response {

    String message;
    Boolean success;
    Object data;

    public Response() {
    }

    public Response(String message, Boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

//    public Response(String s, String reimb_description, String reimb_receipt, Integer ers_users_fk_auth, Integer ers_users_fk_reslvr, Integer ers_reimbursement_status_fk, Integer ers_reimbursement_type_fk, boolean b, Object o) {
//    }

//    public void Response(String s, String reimb_description, Integer ers_users_fk_auth, Integer ers_users_fk_reslvr, Integer ers_reimbursement_status_fk, Integer getErs_reimbursement_type_fk, boolean b, Object o) {
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
