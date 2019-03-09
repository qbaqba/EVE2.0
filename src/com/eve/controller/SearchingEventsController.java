package com.eve.controller;

import com.eve.helper.EventFilter;
import com.eve.model.Event;
import com.eve.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/searchEvents")
public class SearchingEventsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventFilter eventFilter;
        String[] categories = request.getParameterValues("category");
        String minTicketPrice = request.getParameter("minTicketPrice");
        String maxTicketPrice = request.getParameter("maxTicketPrice");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        EventService eventService = new EventService();
        if(eventService.isCorrectInputTicketPrice(minTicketPrice, maxTicketPrice) == true && eventService.isCorrectInputDate(startDate, endDate) == true){
            eventFilter = new EventFilter();
            LocalDate startLocalDate = eventService.changeDateToLocalDate(startDate);
            LocalDate endLocalDate = eventService.changeDateToLocalDate(endDate);
            double minTicketPriceDouble = eventService.changeTicketPriceToDouble(minTicketPrice);
            double maxTicketPriceDouble = eventService.changeTicketPriceToDouble(maxTicketPrice);

            eventFilter.setCategories(categories);
            eventFilter.setMinTicketPrice(minTicketPriceDouble);
            eventFilter.setMaxTicketPrice(maxTicketPriceDouble);
            eventFilter.setStartDate(startLocalDate);
            eventFilter.setEndDate(endLocalDate);

            ArrayList<Event> events = eventService.getFilteredEvents(eventFilter);

            if(events != null){
                request.setAttribute("events", events);
                request.getRequestDispatcher("/DisplayEventController?events=filteredEvents&page=1").forward(request, response);
            }
            else{
                response.sendRedirect("/wrongInputPage.jsp");
            }

        }
        else{
            response.sendRedirect("/wrongInputPage.jsp");
        }


    }
}
