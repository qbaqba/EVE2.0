package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;
import com.eve.model.Manager;

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

    public void convertStrings(){

    }

    public void createNewEvent(String eventName, String eventLocation ){

    }

    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        listOfAllEvents = eventDAO.getAllEvents();
        return listOfAllEvents;
    }

}
