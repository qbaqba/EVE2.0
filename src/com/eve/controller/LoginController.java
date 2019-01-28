package com.eve.controller;

import com.eve.model.Manager;
import com.eve.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.checkManagerExist(login, password);
        if(manager != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("manager", manager);
            response.sendRedirect("/mainPanelManager.jsp");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
