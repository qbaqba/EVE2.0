package com.eve.dao;

import com.eve.helper.EventFilter;
import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;

import java.util.ArrayList;
import java.util.List;

public interface EventDAO {
    public void createNewEvent(Event event);
    public List getAllId();
    public ArrayList<Event> getAllEvents();
    public ArrayList<Event> getAllEventsCreatedByManager(Manager manager);
    public ArrayList<Event> getFilteredEvents(EventFilter eventFilter);
    public Event getEventByEventId(int eventId);
    public ArrayList<Event> getAllEventsForParticpant(Participant participant);

}
