package com.eve.controller;

import com.eve.service.ParticipationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class JoiningToEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String participantId = request.getParameter("participantId");
        String eventId = request.getParameter("eventId");

        System.out.println(participantId);
        System.out.println(eventId);

        //ParticipationService participationService = new ParticipationService();
        //participationService.createParticipation(participantId, eventId);
    }
}
