package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Users;
import com.revature.models.Response;
import com.revature.services.Ers_UsersService;
import com.revature.services.Ers_UsersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Ers_UsersController {

    private static Ers_UsersController ers_usersController;
    Ers_UsersService ers_usersService;

    private Ers_UsersController() {
        ers_usersService = new Ers_UsersServiceImpl();
    }

    public static Ers_UsersController getInstance() {
        if (ers_usersController == null)
            ers_usersController = new Ers_UsersController();
        return ers_usersController;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Ers_Users user = new ObjectMapper().readValue(requestBody, Ers_Users.class);

        Ers_Users tempUser = ers_usersService.login(user);

        if (tempUser != null) {
            //create session if successful
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("userObj", tempUser);

            out.println(new ObjectMapper().writeValueAsString(new Response("login successful", true, tempUser)));
        } else {
            out.println(new ObjectMapper().writeValueAsString(new Response("invalid username or password", false, null)));
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Ers_Users ers_users = new ObjectMapper().readValue(requestBody, Ers_Users.class);
        //try to create user
        Ers_Users tempUser = ers_usersService.register(ers_users);

        if (tempUser != null) {
            //if user was created
            out.println(new ObjectMapper().writeValueAsString(new Response("user has been created", true, tempUser)));
        } else {
            //if username already exists in the system
            out.println(new ObjectMapper().writeValueAsString(new Response("username already exists in the system", false, null)));

        }
    }

    //create checkSession endpoint
    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Ers_Users user = (Ers_Users) req.getSession().getAttribute("userObj");

        if (user != null) {
            out.println(new ObjectMapper().writeValueAsString(new Response("session found", true, user)));
        } else {
            out.println(new ObjectMapper().writeValueAsString(new Response("no session womp womp", false, null)));
        }
    }

    //create endpoint for logout
    public void  logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        //Ers_Users user = (Ers_Users) req.getSession().getAttribute("userObj");

        req.getSession().setAttribute("userObj", null);

        out.println(new ObjectMapper().writeValueAsString(new Response("session terminated",true, null)));
    }
}
