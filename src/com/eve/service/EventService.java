package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.dao.ManagerDAO;
import com.eve.helper.EventFilter;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;

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
        ManagerDAO managerDAO = factory.getManagerDAO();
        event = eventDAO.getEventByEventId(eventId);
        Manager manager = managerDAO.getManagerByEventId(eventId);
        event.setManager(manager);
        return event;
    }

    public ArrayList<Event> getAllEventsCreatedByManager(Manager manager){
        ArrayList<Event> allEvents;
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = daoFactory.getEventDAO();
        ManagerDAO managerDAO = daoFactory.getManagerDAO();
        allEvents = eventDAO.getAllEventsCreatedByManager(manager);
        for(Event event : allEvents){
            event.setManager(managerDAO.getManagerByEventId(event.getId()));
        }
        return allEvents;
    }

    public ArrayList<Event> getAllEventsForParticipant(Participant participant){
        ArrayList<Event> allEvents;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        ManagerDAO managerDAO = factory.getManagerDAO();
        allEvents = eventDAO.getAllEventsForParticpant(participant);
        for(Event event : allEvents){
            event.setManager(managerDAO.getManagerByEventId(event.getId()));
        }
        return allEvents;
    }

    public ArrayList<Event> getFilteredEvents(EventFilter eventFilter){
        ArrayList<Event> filteredEvents;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        ManagerDAO managerDAO = factory.getManagerDAO();
        filteredEvents = eventDAO.getFilteredEvents(eventFilter);
        for(Event event : filteredEvents){
            event.setManager(managerDAO.getManagerByEventId(event.getId()));
        }
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
        return (minTicketPriceDouble <= maxTicketPriceDouble) || (minTicketPriceDouble != 0 && maxTicketPriceDouble == 0);
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

    public ArrayList<Event> getEndedEvents(ArrayList<Event> allEvents){
        ArrayList<Event> endedEvents = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for(Event event : allEvents){
            LocalDateTime endDateTime = event.getEndDate();
            if(now.isAfter(endDateTime)){
                endedEvents.add(event);
            }
        }
        return endedEvents;
    }

    public ArrayList<Event> getNotStartedEvents(ArrayList<Event> allEvents){
        ArrayList<Event> notStartedEvents = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for(Event event : allEvents){
            LocalDateTime startDateTime = event.getStartDate();
            if(now.isBefore(startDateTime)){
                notStartedEvents.add(event);
            }
        }
        return notStartedEvents;
    }
}
