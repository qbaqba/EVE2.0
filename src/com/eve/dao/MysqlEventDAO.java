package com.eve.dao;

import com.eve.helper.converter.EventConverter;
import com.eve.model.Event;
import com.eve.model.EventCategory;
import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEventDAO implements EventDAO {

    private DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
    private ManagerDAO managerDAO = daoFactory.getManagerDAO();


    private static final String INSERT_NEW_EVENT = "INSERT INTO event VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_ALL_EVENTS_BY_MANAGER = "SELECT * FROM event WHERE manager_id=?;";
    private static final String GET_EVENT_BY_ID = "SELECT * FROM event WHERE event_id=?;";

    @Override
    public void createNewEvent(Event event) {
        int eventID = event.getId();
        String eventName = event.getName();
        String eventLocation = event.getLocation();
        String eventDescription = event.getDescription();
        double eventTicketPrice = event.getTicketPrice();
        String eventStartDate = event.getStartDate().toString().replaceAll("T", " ");
        String eventEndDate = event.getEndDate().toString().replaceAll("T", " ");
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

    public ArrayList<Event> getAllEventsCreatedByManager(Manager manager){
        ArrayList<Event> listOfAllEventsCreatedByManager = new ArrayList<>();
        Event event;
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EVENTS_BY_MANAGER);
            preparedStatement.setInt(1, manager.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                event = new Event();
                event.setId(resultSet.getInt("event_id"));
                event.setName(resultSet.getString("event_name"));
                event.setLocation(resultSet.getString("event_location"));
                event.setDescription(resultSet.getString("event_description"));
                event.setTicketPrice(resultSet.getDouble("event_ticket_price"));
                event.setStartDate(resultSet.getTimestamp("event_start_Date").toLocalDateTime());
                event.setEndDate(resultSet.getTimestamp("event_end_date").toLocalDateTime());
                event.setCategory(EventCategory.valueOf(resultSet.getString("event_category").toUpperCase()));
                event.setManager(manager);
                listOfAllEventsCreatedByManager.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllEventsCreatedByManager;
    }

    public Event getEventByEventId(int eventId){
        Event event = new Event();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_EVENT_BY_ID);
            preparedStatement.setInt(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                event.setId(resultSet.getInt("event_id"));
                event.setName(resultSet.getString("event_name"));
                event.setLocation(resultSet.getString("event_location"));
                event.setDescription(resultSet.getString("event_description"));
                event.setTicketPrice(resultSet.getDouble("event_ticket_price"));
                event.setStartDate(resultSet.getTimestamp("event_start_Date").toLocalDateTime());
                event.setEndDate(resultSet.getTimestamp("event_end_date").toLocalDateTime());
                event.setCategory(EventCategory.valueOf(resultSet.getString("event_category").toUpperCase()));
                int managerId = resultSet.getInt("manager_id");
                Manager manager = managerDAO.getManagerByManagerId(managerId);
                event.setManager(manager);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }


    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> listOfAllEvents = new ArrayList<>();
        Event event;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();

      /*  try (Connection connection = ConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_EVENTS_MYSQL_QUERY);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                int managerId = resultSet.getInt("manager_id");
                int usersCounter = resultSet.getInt("users");
                Manager manager = managerDAO.getManagerById(managerId);
                event = new Event(name, location, manager);
                event.setId(id);
                event.setUsersCounter(usersCounter);
                listOfAllEvents.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return listOfAllEvents;
    }
}
