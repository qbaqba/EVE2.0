package com.eve.controller;

import com.eve.model.Manager;
import com.eve.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.getManager(login, password);
        if(manager != null){
            request.getSession(true).setAttribute("login", manager.getLogin());
            response.sendRedirect(request.getContextPath()+"/");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
