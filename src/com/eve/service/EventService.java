package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;

import java.util.ArrayList;

public class EventService {

    public void createEvent(Event event){
        Event newEvent = event;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        IdGenerator idGenerator = new IdGenerator(eventDAO.getAllId());
        newEvent.setId(idGenerator.selectCorrectId());
        eventDAO.createNewEvent(newEvent);
    }

    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        listOfAllEvents = eventDAO.getAllEvents();
        return listOfAllEvents;
    }

}
