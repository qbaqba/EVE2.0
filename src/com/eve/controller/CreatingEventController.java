package com.eve.controller;

import com.eve.helper.converter.EventConverter;
import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.service.EventService;
import com.eve.service.ManagerService;
import com.eve.util.ConnectionProvider;
import com.eve.verifier.EventVerifier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;

@WebServlet("/CreatingEventController")
public class CreatingEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime createDate = LocalDateTime.now();

        String name, location, description, price, dateStart, dateEnd, timeStart, timeEnd, category;
        Manager manager = (Manager) request.getSession().getAttribute("loggedUser");

        name = request.getParameter("inputName");
        location = request.getParameter("inputLocation");
        description = request.getParameter("inputDescription");
        price = request.getParameter("inputPrice");
        dateStart = request.getParameter("inputStartDate");
        dateEnd = request.getParameter("inputEndDate");
        timeStart = request.getParameter("inputStartTime");
        timeEnd = request.getParameter("inputEndTime");
        category = request.getParameter("inputCategory");

        EventVerifier eventVerifier = new EventVerifier(name,location,description,price);
        eventVerifier.setDate(dateStart, timeStart, dateEnd, timeEnd);
        eventVerifier.setCategory(category);
        eventVerifier.setEventInputConverter();
        eventVerifier.setIsCorrectInput();

        if(eventVerifier.isCorrectInput()){
            EventConverter event = new EventConverter(price, category, manager);
            event.setDate(dateStart, dateEnd, timeStart, timeEnd);
            event.setNotConvertedFields(name, location, description);
            event.setConvertedFields();
            event.setCreateDate(createDate);
            EventService eventService = new EventService();
            eventService.createEvent(event);
        }
        else{
            response.sendRedirect("/wrongInputPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
