package com.eve.controller;

import com.eve.model.Manager;
import com.eve.service.EventService;
import com.eve.service.ManagerService;
import com.eve.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/CreatingEventController")
public class CreatingEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("inputName");
        String location = request.getParameter("inputLocation");
        Manager manager = (Manager) request.getSession(false).getAttribute("manager");
        EventService eventService = new EventService();

        System.out.println(name + location + manager.getLogin()+manager.getId()+manager.getPassword());
        eventService.createEvent(name, location, manager);
        response.sendRedirect("/mainPanelManager.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
