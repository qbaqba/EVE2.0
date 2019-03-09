package com.eve.controller;

import com.eve.model.Manager;
import com.eve.model.Participant;
import com.eve.service.ManagerService;
import com.eve.service.ParticipantService;
import com.eve.service.SubscriptionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/follow")
public class FollowController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String managerId = request.getParameter("managerId");
        String participantId = request.getParameter("participantId");
        int managerIdInt = Integer.parseInt(managerId);
        int participantIdInt = Integer.parseInt(participantId);
        ManagerService managerService = new ManagerService();
        ParticipantService participantService = new ParticipantService();
        SubscriptionService subscriptionService = new SubscriptionService();
        Participant participant = participantService.getParticipantByParticipantId(participantIdInt);
        Manager manager = managerService.getManagerByManagerId(managerIdInt);
        ArrayList<Participant> allParticipantsForManager = participantService.getAllParticipantsForManager(manager);

        if(action.equals("follow")){
            if(!allParticipantsForManager.contains(participant)){
                subscriptionService.createSubscription(participantIdInt, managerIdInt);
                response.sendRedirect("/participantMainPanel.jsp");
            }
            else{
                response.sendRedirect("/wrongInputPage.jsp");
            }
        }
        else if(action.equals("unfollow")){
            subscriptionService.deleteSubscription(participantIdInt, managerIdInt);
            response.sendRedirect("/participantMainPanel.jsp");
        }


    }
}
