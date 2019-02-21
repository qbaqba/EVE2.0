package com.eve.dao;

import com.eve.model.Event;
import com.eve.model.Manager;

import java.util.ArrayList;
import java.util.List;

public interface EventDAO {
    public void createNewEvent(Event event);
    public List getAllId();
    public ArrayList<Event> getAllEvents();
    public ArrayList<Event> getAllEventsCreatedByManager(Manager manager);
}
