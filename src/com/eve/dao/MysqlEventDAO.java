package com.eve.dao;

import com.eve.model.Event;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEventDAO implements EventDAO {

    private static final String CREATE_EVENT_MYSQL_QUERY = "INSERT INTO event VALUES(?, ?, ?, ?, ?);";

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
           /* preparedStatement.setInt(1, 443);
            preparedStatement.setString(2, "cos");
            preparedStatement.setString(3, "gdzies");
            preparedStatement.setInt(4,3462);
            preparedStatement.setInt(5,0);
            preparedStatement.executeUpdate();*/

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
}
