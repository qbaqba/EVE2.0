package com.eve.controller;

import com.eve.model.Event;
import com.eve.model.Participant;
import com.eve.model.Participation;
import com.eve.service.EventService;
import com.eve.service.ParticipationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/participation")
public class JoiningToEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Participant loggedParticipant = (Participant) request.getSession(false).getAttribute("loggedUser");
        ArrayList<Event> eventsForParticipant = loggedParticipant.getListOfAllParticipantEvents();
        String participantId = request.getParameter("participantId");
        String eventId = request.getParameter("eventId");
        String action = request.getParameter("action");
        int participantIdInt = Integer.parseInt(participantId);
        int eventIdInt = Integer.parseInt(eventId);
        EventService eventService = new EventService();
        Event event = eventService.getEventByEventId(eventIdInt);

        Participation participation = new Participation(participantIdInt, eventIdInt);
        ParticipationService participationService = new ParticipationService();

        if(action.equals("join")){
            if(!eventsForParticipant.contains(event)){
                participationService.createParticipation(participantIdInt, eventIdInt);
                response.sendRedirect("/participantMainPanel.jsp");
            }
            else {
                response.sendRedirect("/wrongInputPage.jsp");
            }
        }
        else if(action.equals("quit")){
            participationService.deleteParticipation(participantIdInt, eventIdInt);
            response.sendRedirect("/participantMainPanel.jsp");
        }










    }
}
