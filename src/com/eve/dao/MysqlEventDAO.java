package com.eve.dao;

import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEventDAO implements EventDAO {

    private static final String CREATE_EVENT_MYSQL_QUERY = "INSERT INTO event VALUES(?, ?, ?, ?, ?);";
    private static final String GET_ALL_EVENTS_MYSQL_QUERY = "SELECT * FROM event;";

    @Override
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

        try (Connection connection = ConnectionProvider.getConnection()) {
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
        }
        return listOfAllEvents;
    }
}
