package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Reimbursements;
import com.revature.models.Response;
import com.revature.services.Ers_ReimbursementService;
import com.revature.services.Ers_ReimbursementServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Ers_ReimbursementController {

    private static Ers_ReimbursementController ers_reimbursementController;
    Ers_ReimbursementService ers_reimbursementService;

    public Ers_ReimbursementController() {
        ers_reimbursementService = new Ers_ReimbursementServiceImpl();
    }

    public static Ers_ReimbursementController getInstance() {
        if (ers_reimbursementController == null)
            ers_reimbursementController = new Ers_ReimbursementController();

        return ers_reimbursementController;
    }

    public void addReimbursementRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Ers_Reimbursement ers_reimbursement = new ObjectMapper().readValue(requestBody, Ers_Reimbursement.class);

        ers_reimbursementService.addReimbursementRequest(ers_reimbursement);

        out.println(new ObjectMapper().writeValueAsString(new Response("reimbursement request has been added", true, ers_reimbursement)));
    }

    public void viewAllReimbTicketsByEmpId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        int ers_users_fk_auth = Integer.parseInt(req.getParameter("id"));
        out.println(new ObjectMapper().writeValueAsString(new Response("list retrieved", true, ers_reimbursementService.viewAllReimbTicketsByEmpId(ers_users_fk_auth))));

        System.out.println(ers_reimbursementService.viewAllReimbTicketsByEmpId(ers_users_fk_auth));


    }

    public void viewAllReimbursementsByManagerId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer ers_users_fk_rslvr = Integer.parseInt(req.getParameter("id"));
        out.println(new ObjectMapper().writeValueAsString(new Response("list retrieved", true, ers_reimbursementService.viewAllReimbursementsByManagerId(ers_users_fk_rslvr))));

        System.out.println(ers_reimbursementService.viewAllReimbursementsByManagerId(ers_users_fk_rslvr));

    }

    public void updateReimbursementRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Ers_Reimbursement ers_reimbursement = new ObjectMapper().readValue(requestBody, Ers_Reimbursement.class);

        Reimbursements reimbursements = ers_reimbursementService.updateReimbursementRequest(ers_reimbursement);

        out.println(new ObjectMapper().writeValueAsString(new Response("reimbursement request has been updated", true, reimbursements)));

    }

    public void viewAllEmpReimbursementsByStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        int ers_users_fk_reslvr = Integer.parseInt(req.getParameter("resolverId"));
        String reimb_status =req.getParameter("reimb_status");
        out.println(new ObjectMapper().writeValueAsString(new Response("list retrieved", true, ers_reimbursementService.viewAllEmpReimbursementsByStatus(ers_users_fk_reslvr, reimb_status))));


    }
    public void viewEmpReimbByStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        int ers_users_fk_auth = Integer.parseInt(req.getParameter("authorId"));
        String reimb_status =(req.getParameter("reimb_status"));
        out.println(new ObjectMapper().writeValueAsString(new Response("list retrieved", true, ers_reimbursementService.viewEmpReimbByStatus(ers_users_fk_auth, reimb_status))));

    }
}
