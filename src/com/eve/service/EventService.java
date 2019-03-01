package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.dao.ManagerDAO;
import com.eve.helper.EventFilter;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventService {

    public void createEvent(Event event){
        Event newEvent = event;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        IdGenerator idGenerator = new IdGenerator(eventDAO.getAllId());
        newEvent.setId(idGenerator.selectCorrectId());
        eventDAO.createNewEvent(newEvent);
    }

    public Event getEventByEventId(int eventId){
        Event event;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        event = eventDAO.getEventByEventId(eventId);
        return event;
    }

    public ArrayList<Event> getFilteredEvents(EventFilter eventFilter){
        ArrayList<Event> filteredEvents;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        filteredEvents = eventDAO.getFilteredEvents(eventFilter);
        return filteredEvents;
    }

    public boolean isCorrectInputDate(String startDate, String endDate){
        LocalDate startDateLocalDate = changeDateToLocalDate(startDate);
        LocalDate endDateLocalDate = changeDateToLocalDate(endDate);
        if(startDateLocalDate != null && endDateLocalDate != null){
            return (!startDateLocalDate.isAfter(endDateLocalDate));
        }
        else{
            return true;
        }
    }

    public LocalDate changeDateToLocalDate(String date){
        LocalDate dateLocalDate;
        if(date.isBlank()){
            dateLocalDate = null;
        }
        else{
            int year = Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));
            dateLocalDate = LocalDate.of(year, month, day);
        }
        return dateLocalDate;
    }

    public boolean isCorrectInputTicketPrice(String minTicketPrice, String maxTicketPrice){
        Pattern pattern = Pattern.compile("\\s*\\d*\\,?\\d*");
        Matcher matcherMinTicketPrice = pattern.matcher(minTicketPrice);
        Matcher matcherMaxTicketPrice = pattern.matcher(maxTicketPrice);
        if(matcherMinTicketPrice.matches() && matcherMaxTicketPrice.matches()){
            return compareTicketPrices(minTicketPrice, maxTicketPrice);
        }
        else {
            return false;
        }
    }

    public boolean compareTicketPrices(String minTicketPrice, String maxTicketPrice){
        double minTicketPriceDouble = changeTicketPriceToDouble(minTicketPrice);
        double maxTicketPriceDouble = changeTicketPriceToDouble(maxTicketPrice);
        return minTicketPriceDouble <= maxTicketPriceDouble;
    }

    public double changeTicketPriceToDouble(String ticketPrice){
        double ticketPriceDouble;
        if(ticketPrice.isBlank()){
            ticketPriceDouble = 0;
        }
        else {
            if(ticketPrice.contains(",")){
                ticketPriceDouble = Double.parseDouble(ticketPrice.replaceAll(",", "."));
            }
            else {
                ticketPriceDouble = Double.parseDouble(ticketPrice);
            }
        }
        return ticketPriceDouble;
    }

    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        listOfAllEvents = eventDAO.getAllEvents();
        return listOfAllEvents;
    }

}
