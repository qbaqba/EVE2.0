package com.eve.controller;

import com.eve.model.Event;
import com.eve.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DisplayingThisEventController")
public class DisplayingThisEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        EventService eventService = new EventService();
        Event event = eventService.getEventByEventId(Integer.parseInt(eventId));
        System.out.println(event.getLocation());

        request.setAttribute("event", event);
        request.getRequestDispatcher("/event.jsp").forward(request, response);
    }
}
