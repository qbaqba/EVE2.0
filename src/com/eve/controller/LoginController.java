package com.eve.controller;

import com.eve.model.Manager;
import com.eve.model.Participant;
import com.eve.service.ManagerService;
import com.eve.service.ParticipantService;

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
        ParticipantService participantService = new ParticipantService();
        HttpSession session = request.getSession(false);
        if(managerService.checkLoginPassword(login,password) == true){
            Manager loggedManager = managerService.getManagerByLogin(login);
            session.setAttribute("loggedUser", loggedManager);
            response.sendRedirect("/mainPanelManager.jsp");
        }
        else if(participantService.checkLoginPassword(login, password) == true){
            Participant loggedParticipant = participantService.getParticipantByLogin(login);
            session.setAttribute("loggedUser", loggedParticipant);
            response.sendRedirect("/index.jsp");
        }
        else response.sendRedirect("/wrongInputPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
