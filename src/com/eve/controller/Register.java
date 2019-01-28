package com.eve.controller;

import com.eve.service.ManagerService;
import com.eve.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String accountType = request.getParameter("accountType");
        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");
        if(accountType.equals("manager")){
            ManagerService managerService = new ManagerService();
            managerService.addManager(login, password);
        }
        else if(accountType.equals("user")){
            UserService userService = new UserService();
            userService.addUser(login, password);
        }
        response.sendRedirect(request.getContextPath()+"/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
