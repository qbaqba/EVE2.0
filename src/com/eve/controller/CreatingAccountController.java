package com.eve.controller;

import com.eve.helper.InputVerifier;
import com.eve.service.ManagerService;
import com.eve.service.ParticipantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/creatingAccountController")
public class CreatingAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");
        InputVerifier inputVerifier = new InputVerifier(3, 15);

        if(inputVerifier.checkLengthOfString(login) == false || inputVerifier.checkLengthOfString(password) == false){
            response.sendRedirect("/wrongInputPage.jsp");
        }
        else {
            ParticipantService participantService = new ParticipantService();
            ManagerService managerService = new ManagerService();
            if(managerService.checkLoginAvailability(login) == true && participantService.checkLoginAvailability(login) == true){
                if(session.getAttribute("accountType").equals("participant")){
                    participantService.createNewParticipant(login, password);
                    response.sendRedirect("/index.jsp");
                }
                else if(session.getAttribute("accountType").equals("manager")){
                    managerService.createNewManager(login, password);
                    response.sendRedirect("/index.jsp");
                }
            }
            else response.sendRedirect("/wrongInputPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
