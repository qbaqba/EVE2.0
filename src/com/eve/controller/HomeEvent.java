package com.eve.controller;

import com.eve.model.Event;
import com.eve.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/HomeEvent")
public class HomeEvent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventService eventService = new EventService();
        ArrayList<Event> listOfAllEvents = eventService.getAllEvents();
        request.setAttribute("events", listOfAllEvents);
        request.getRequestDispatcher("/eventPanel.jsp").forward(request,response);
    }
}
