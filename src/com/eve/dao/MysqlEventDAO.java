package com.eve.dao;

import com.eve.helper.EventFilter;
import com.eve.model.Event;
import com.eve.model.EventCategory;
import com.eve.model.Manager;
import com.eve.model.Participant;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class MysqlEventDAO implements EventDAO {

    private DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
    private ManagerDAO managerDAO = daoFactory.getManagerDAO();



    private static final String INSERT_NEW_EVENT = "INSERT INTO event VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_ALL_EVENTS_BY_MANAGER = "SELECT * FROM event WHERE manager_id=?;";
    private static final String GET_EVENT_BY_ID = "SELECT * FROM event WHERE event_id=?;";
    private static final String GET_PARTICIPANT_EVENTS = "SELECT event_id FROM participation WHERE participant_id=?;";

    @Override
    public void createNewEvent(Event event) {
        int eventID = event.getId();
        String eventName = event.getName();
        String eventLocation = event.getLocation();
        String eventDescription = event.getDescription();
        double eventTicketPrice = event.getTicketPrice();
        String eventStartDate = event.getStartDate().toString().replaceAll("T", " ");
        String eventEndDate = event.getEndDate().toString().replaceAll("T", " ");
        String eventCreateDate = event.getCreateDate().toString().replaceAll("T", " ");
        String eventCategory = String.valueOf(event.getCategory()).toLowerCase();
        int managerID = event.getManager().getId();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EVENT);
            preparedStatement.setInt(1, eventID);
            preparedStatement.setString(2, eventName);
            preparedStatement.setString(3, eventLocation);
            preparedStatement.setString(4, eventDescription);
            preparedStatement.setDouble(5, eventTicketPrice);
            preparedStatement.setString(6, eventStartDate);
            preparedStatement.setString(7, eventEndDate);
            preparedStatement.setString(8, eventCategory);
            preparedStatement.setInt(9, managerID);
            preparedStatement.setString(10, eventCreateDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> listOfAllId = new ArrayList<Integer>();

        try (Connection connection = ConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT event_id FROM event;");
            while(resultSet.next()){
                listOfAllId.add(resultSet.getInt("event_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllId;
    }
    /////////////////////////////////////////////////////////////////////
    public ArrayList<Event> getAllEventsCreatedByManager(Manager manager){
        ArrayList<Event> listOfAllEventsCreatedByManager = new ArrayList<>();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EVENTS_BY_MANAGER);
            preparedStatement.setInt(1, manager.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            listOfAllEventsCreatedByManager = getEventsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllEventsCreatedByManager;
    }

    public ArrayList<Event> getAllEventsForParticpant(Participant participant){
        ArrayList<Event> allEventsForParticipant;
        ArrayList<Integer> allEventId = getAllEventIdForParticipant(participant);
        allEventsForParticipant = getAllEventsForEventId(allEventId);
        return allEventsForParticipant;
    }

    public ArrayList<Integer> getAllEventIdForParticipant(Participant participant){
        ArrayList<Integer> allEventId = new ArrayList<>();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PARTICIPANT_EVENTS);
            preparedStatement.setInt(1, participant.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int eventId = resultSet.getInt("event_id");
                allEventId.add(eventId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEventId;
    }
    /////////////////////////////////////////////////////////////////////
    public ArrayList<Event> getAllEventsForEventId(ArrayList<Integer> listOfEventsId){
        ArrayList<Event> allEvents = new ArrayList<>();
        String query = "SELECT * FROM event WHERE event_id=?;";
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(int eventId : listOfEventsId){
                Event event;
                preparedStatement.setInt(1, eventId);
                ResultSet resultSet = preparedStatement.executeQuery();
                event = getEventFromResultSet(resultSet);
                allEvents.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEvents;
    }
    /////////////////////////////////////////////////////////////////////
    public Event getEventByEventId(int eventId){
        Event event = new Event();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_EVENT_BY_ID);
            preparedStatement.setInt(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            event = getEventFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }
    /////////////////////////////////////////////////////////////////////
    public Event getEventFromResultSet(ResultSet resultSet) throws SQLException {
        Event event = new Event();
        try{
            resultSet.next();
            event.setId(resultSet.getInt("event_id"));
            event.setName(resultSet.getString("event_name"));
            event.setLocation(resultSet.getString("event_location"));
            event.setDescription(resultSet.getString("event_description"));
            event.setTicketPrice(resultSet.getDouble("event_ticket_price"));
            event.setStartDate(resultSet.getTimestamp("event_start_Date").toLocalDateTime());
            event.setEndDate(resultSet.getTimestamp("event_end_date").toLocalDateTime());
            event.setCategory(EventCategory.valueOf(resultSet.getString("event_category").toUpperCase()));
            event.setCreateDate(resultSet.getTimestamp("event_create_date").toLocalDateTime());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return event;
    }
    /////////////////////////////////////////////////////////////////////
    public ArrayList<Event> getEventsFromResultSet(ResultSet resultSet){
        ArrayList<Event> events = new ArrayList<>();
        try {
            while(resultSet.next()){
                Event event = new Event();
                event.setId(resultSet.getInt("event_id"));
                event.setName(resultSet.getString("event_name"));
                event.setLocation(resultSet.getString("event_location"));
                event.setDescription(resultSet.getString("event_description"));
                event.setTicketPrice(resultSet.getDouble("event_ticket_price"));
                event.setStartDate(resultSet.getTimestamp("event_start_Date").toLocalDateTime());
                event.setEndDate(resultSet.getTimestamp("event_end_date").toLocalDateTime());
                event.setCategory(EventCategory.valueOf(resultSet.getString("event_category").toUpperCase()));
                event.setCreateDate(resultSet.getTimestamp("event_create_date").toLocalDateTime());
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        Event event;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        return listOfAllEvents;
    }

    public ArrayList<Event> getFilteredEvents(EventFilter eventFilter){
        ArrayList<Event> filteredEvents;

        String[] categories = eventFilter.getCategories();
        double minTicketPrice = eventFilter.getMinTicketPrice();
        double maxTicketPrice = eventFilter.getMaxTicketPrice();
        LocalDate startDate = eventFilter.getStartDate();
        LocalDate endDate = eventFilter.getEndDate();

        ArrayList<Event> filteredEventsByCategories = getFilteredEventsByCategories(categories);
        ArrayList<Event> filteredEventsByTicketPrice = getFilteredEventsByTicketPrice(minTicketPrice, maxTicketPrice);
        ArrayList<Event> filteredEventsByDate = getFilteredEventsByDate(startDate, endDate);

        filteredEventsByCategories.retainAll(filteredEventsByTicketPrice);
        filteredEventsByCategories.retainAll(filteredEventsByDate);
        filteredEvents = filteredEventsByCategories;
        return filteredEvents;
    }

    public ArrayList<Event> getFilteredEventsByCategories(String[] categories){
        ArrayList<Event> filteredEventsByCategories = new ArrayList<>();
        String queryForCategories = setQueryForCategories(categories);
        try{
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryForCategories);
            filteredEventsByCategories = getEventsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredEventsByCategories;
    }

    public String setQueryForCategories(String[] categories){
        String queryForCategories;
        if(categories == null){
            queryForCategories = "SELECT * FROM event";
        }
        else{
            String condition = "";
            String additionalCondition;

            for(int i = 0; i < categories.length; i++){
                additionalCondition = "event_category = '" + categories[i] +"' ";
                condition = condition + additionalCondition;
                if(categories.length - i != 1){
                    condition = condition + " OR ";
                }
            }
            condition = condition + ";";
            queryForCategories = "SELECT * FROM event WHERE " + condition;
        }
        return queryForCategories;
    }

    public ArrayList<Event> getFilteredEventsByTicketPrice(double minTicketPrice, double maxTicketPrice){
        ArrayList<Event> filteredEventsByTicketPrice = new ArrayList<>();
        String queryForTicketPrice = setQueryForTicketPrice(minTicketPrice, maxTicketPrice);
        try{
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryForTicketPrice);
            filteredEventsByTicketPrice = getEventsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredEventsByTicketPrice;
    }

    public String setQueryForTicketPrice(double minTicketPrice, double maxTicketPrice){
        String query;
        if(minTicketPrice == 0 && maxTicketPrice == 0){
            query = "SELECT * FROM event;";
        }
        else if(minTicketPrice != 0 && maxTicketPrice == 0){
            query = "SELECT * FROM event WHERE event_ticket_price > "+minTicketPrice+";";
        }
        else if(maxTicketPrice != 0 && minTicketPrice == 0){
            query = "SELECT * FROM event WHERE event_ticket_price < "+maxTicketPrice+";";
        }
        else {
            if(minTicketPrice == maxTicketPrice){
                query = "SELECT * FROM event WHERE event_ticket_price = "+minTicketPrice+";";
            }
            else {
                query = "SELECT * FROM event WHERE event_ticket_price > "+minTicketPrice+" AND event_ticket_price < "+maxTicketPrice+";";
            }
        }
        return query;
    }

    public ArrayList<Event> getFilteredEventsByDate(LocalDate startDate, LocalDate endDate){
        ArrayList<Event> filteredEventsByDate = new ArrayList<>();
        String queryForDate = setQueryForDate(startDate, endDate);
        try{
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryForDate);
            filteredEventsByDate = getEventsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredEventsByDate;
    }

    public String setQueryForDate(LocalDate startDate, LocalDate endDate){
        String query;
        if(startDate == null && endDate == null){
            query = "SELECT * FROM event;";
        }
        else if(startDate != null && endDate == null){
            query = "SELECT * FROM event WHERE event_start_Date > '"+startDate+"';";
        }
        else if(endDate != null && startDate == null){
            query = "SELECT * FROM event WHERE event_start_Date < '"+endDate+"';";
        }
        else{
            if(startDate.isEqual(endDate)){
                LocalTime startTime = LocalTime.of(0,0);
                LocalTime endTime = LocalTime.of(23,59);
                LocalDateTime start = LocalDateTime.of(startDate, startTime);
                LocalDateTime end = LocalDateTime.of(endDate, endTime);
                query = "SELECT * FROM event WHERE event_start_Date > '"+start+"' AND " +
                        "event_start_Date < '"+end+"';";
            }
            else {
                query = "SELECT * FROM event WHERE event_start_Date > '"+startDate+"' AND " +
                        "event_start_Date < '"+endDate+"';";
            }
        }
        return query;
    }

}
