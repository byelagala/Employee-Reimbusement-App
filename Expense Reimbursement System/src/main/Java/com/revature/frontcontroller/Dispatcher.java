package com.revature.frontcontroller;

import com.revature.controller.Ers_ReimbursementController;
import com.revature.controller.Ers_UsersController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/api/*")
public class Dispatcher extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        System.out.println(URI);

        switch (URI) {
            case "/api/login":
                if (req.getMethod().equals("POST"))
                    Ers_UsersController.getInstance().login(req, resp);
                break;
            case "/api/register":
                if (req.getMethod().equals("POST"))
                    Ers_UsersController.getInstance().register(req, resp);
                break;
            case "/api/reimbursements":
                switch (req.getMethod()) {
                    case "GET":
                        Ers_ReimbursementController.getInstance().viewAllEmpReimbursementsByStatus(req, resp);
                }
                break;
            case "/api/manager":
                switch (req.getMethod()) {
                    case "GET":
                        Ers_ReimbursementController.getInstance().viewAllReimbursementsByManagerId(req, resp);
                        break;
                    case "PATCH":
                        Ers_ReimbursementController.getInstance().updateReimbursementRequest(req, resp);
                        break;
                }
                break;

            case "/api/ers_reimbursement":
                switch (req.getMethod()) {
                    case "POST":
                        Ers_ReimbursementController.getInstance().addReimbursementRequest(req, resp);
                        break;
                    case "GET":
                        Ers_ReimbursementController.getInstance().viewAllReimbTicketsByEmpId(req, resp);
                        break;
                }
            case "/api/employee_status":
                switch (req.getMethod()) {
                    case "GET":
                        Ers_ReimbursementController.getInstance().viewEmpReimbByStatus(req, resp);
                        break;
                }
                break;

            case "/api/check-session":
                if (req.getMethod().equals("GET")) ;
                Ers_UsersController.getInstance().checkSession(req, resp);
                break;
            case "/api/logout":
                if (req.getMethod().equals("GET"))
                    Ers_UsersController.getInstance().logout(req, resp);
                break;
        }
    }
}
