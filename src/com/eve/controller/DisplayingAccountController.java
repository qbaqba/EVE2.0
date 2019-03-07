package com.eve.controller;

import com.eve.model.Manager;
import com.eve.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class DisplayingAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        int accountIdInt = Integer.parseInt(accountId);
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.getManagerByManagerId(accountIdInt);
        request.setAttribute("manager", manager);
        request.getRequestDispatcher("/accountPanel.jsp").forward(request, response);
    }
}
