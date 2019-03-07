package com.eve.controller;

import com.eve.model.Event;
import com.eve.model.Participant;
import com.eve.service.EventService;
import com.eve.service.ParticipantService;
import com.eve.service.ParticipationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DisplayingThisEventController")
public class DisplayingThisEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        Participant loggedParticipant = (Participant) request.getSession(false).getAttribute("loggedUser");
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        Event event = eventService.getEventByEventId(Integer.parseInt(eventId));
        ArrayList<Participant> allParticipantForEvent = participantService.getAllParticipantForEvent(event);
        ArrayList<Event> eventsForParticipant = loggedParticipant.getListOfAllParticipantEvents();
        Boolean isParticipation;
        if(eventsForParticipant.contains(event)){
            isParticipation = true;
        }
        else{
            isParticipation = false;
        }
        request.setAttribute("participants", allParticipantForEvent);
        request.setAttribute("isParticipation", isParticipation);
        request.setAttribute("event", event);
        request.getRequestDispatcher("/event.jsp").forward(request, response);
    }
}
