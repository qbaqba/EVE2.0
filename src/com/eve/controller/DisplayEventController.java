package com.eve.controller;

import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.service.EventService;
import com.eve.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DisplayEventController")
public class DisplayEventController extends HttpServlet {

    ManagerService managerService = new ManagerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventsToReturn = request.getParameter("events");
        String pageNumber = request.getParameter("page");

        ArrayList<Event> listOfAllEvents = setListOfAllEvents(eventsToReturn, request, response);
        int pageNumberToInt = setPageNumberToInt(pageNumber);
        int countOfPages = setCountOfPages(listOfAllEvents);
        ArrayList<Event> listOfEventsForPage = setListOfEventsForPage(pageNumberToInt, countOfPages, listOfAllEvents);
        request.setAttribute("pageNumber", pageNumberToInt);
        request.setAttribute("countOfPages", countOfPages);
        request.setAttribute("listOfEventsForPage", listOfEventsForPage);
        request.getRequestDispatcher("/cardTest.jsp").forward(request, response);

    }

    public int setPageNumberToInt(String pageNumber){
        int pageNumberToInt;
        if(pageNumber == null){
            pageNumberToInt = 1;
        }
        else {
            pageNumberToInt = Integer.parseInt(pageNumber);
        }
        return pageNumberToInt;
    }

    public static int setCountOfPages(ArrayList<Event> listOfAllEvents){
        int countOfPages;
        int countOfAllEvents = listOfAllEvents.size();

        if(countOfAllEvents == 0){
            countOfPages = 0;
        }
        else if(countOfAllEvents > 0 && countOfAllEvents <= 9){
            countOfPages = 1;
        }
        else{
            if(countOfAllEvents % 9 == 0){
                countOfPages = countOfAllEvents / 9;
            }
            else{
                countOfPages = (countOfAllEvents / 9) + 1;
            }
        }
        return countOfPages;
    }

    public ArrayList<Event> setListOfAllEvents(String eventsToReturn, HttpServletRequest request, HttpServletResponse response){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        if(eventsToReturn.equals("managerEvents")){
            Manager loggedManager = (Manager) request.getSession(false).getAttribute("loggedUser");
            listOfAllEvents = loggedManager.getListOfCreatedEvents();
        }
        else {
            Manager manager = managerService.getManagerByLogin(eventsToReturn);
            listOfAllEvents = manager.getListOfCreatedEvents();
        }
        return listOfAllEvents;
    }

    public ArrayList<Event> setListOfEventsForPage(int page,int countOfPages, ArrayList<Event> listOfAllEvents){
        int minINDEX;
        int maxINDEX;
        ArrayList<Event> listOfEventsForPage = new ArrayList<>();

        minINDEX = 9*(page - 1);
        if(page < countOfPages){
            maxINDEX = (9 * page) - 1;
        }
        else{
            maxINDEX = listOfAllEvents.size() - 1;
        }
        for(int i = minINDEX; i <= maxINDEX; i++){
            Event eventToAdd = listOfAllEvents.get(i);
            listOfEventsForPage.add(eventToAdd);
        }
        return listOfEventsForPage;
    }


}
