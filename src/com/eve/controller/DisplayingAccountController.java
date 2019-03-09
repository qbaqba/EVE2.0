package com.eve.controller;

import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;
import com.eve.service.EventService;
import com.eve.service.ManagerService;
import com.eve.service.ParticipantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/account")
public class DisplayingAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");

        Participant loggedParticipant = (Participant) request.getSession(false).getAttribute("loggedUser");


        int accountIdInt = Integer.parseInt(accountId);
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.getManagerByManagerId(accountIdInt);
        EventService eventService = new EventService();
        manager.setListOfCreatedEvents(eventService.getAllEventsCreatedByManager(manager));
        ParticipantService participantService = new ParticipantService();

        Participant participant = participantService.getParticipantByParticipantId(loggedParticipant.getId());
        ArrayList<Participant> followersParticipants = participantService.getAllParticipantsForManager(manager);

        boolean isFollowed;

        if(followersParticipants.contains(participant)){
            isFollowed = true;
        }
        else{
            isFollowed = false;
        }


        ArrayList<Event> notStartedEvents = eventService.getNotStartedEvents(manager.getListOfCreatedEvents());
        ArrayList<Event> endedEvents = eventService.getEndedEvents(manager.getListOfCreatedEvents());
        int notStartedEventsSize = notStartedEvents.size();
        int endedEventsSize = endedEvents.size();




        request.setAttribute("notStartedEvents", notStartedEvents);
        request.setAttribute("endedEvents", endedEvents);
        request.setAttribute("notStartedEventsSize", notStartedEventsSize);
        request.setAttribute("endedEventsSize", endedEventsSize);

        request.setAttribute("followers", followersParticipants);
        request.setAttribute("isFollowed", isFollowed);

        request.setAttribute("manager", manager);
        request.getRequestDispatcher("/accountPanel.jsp").forward(request, response);
    }
}
