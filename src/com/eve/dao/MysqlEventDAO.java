package com.eve.dao;

import com.eve.model.Event;
import com.eve.model.EventCategory;
import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEventDAO implements EventDAO {

    private static final String INSERT_NEW_EVENT = "INSERT INTO event VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_ALL_EVENTS_MYSQL_QUERY = "SELECT * FROM event;";





   /* @Override
    public void create(Event event) {
        int id = event.getId();
        int users = event.getUsersCounter();
        String name = event.getName();
        String location = event.getLocation();
        int managerId = event.getManager().getId();

        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EVENT_MYSQL_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, location);
            preparedStatement.setInt(4,managerId);
            preparedStatement.setInt(5,users);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

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
            ResultSet resultSet = statement.executeQuery("SELECT id FROM event;");
            while(resultSet.next()){
                listOfAllId.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllId;
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
