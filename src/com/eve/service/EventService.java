package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;
import com.eve.model.Manager;

import java.util.ArrayList;

public class EventService {

    public void createEvent(String name, String location, Manager manager){
       /* Event event = new Event(name, location, manager);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        IdGenerator idGenerator = new IdGenerator(eventDAO.getAllId());
        event.setId(idGenerator.selectCorrectId());
        eventDAO.create(event);*/
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
