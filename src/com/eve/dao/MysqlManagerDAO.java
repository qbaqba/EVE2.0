package com.eve.dao;

import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlManagerDAO implements ManagerDAO {

    private static final String CREATE_MANAGER_SQL_QUERRY = "INSERT INTO MANAGER VALUES(?, ?, ?);";

    @Override
    public void create(Manager manager) {
        int id = manager.getId();
        String login = manager.getLogin();
        String password = manager.getPassword();

        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MANAGER_SQL_QUERRY);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> listOfAllId = new ArrayList<Integer>();

        try (Connection connection = ConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM Manager;");
            while(resultSet.next()){
                listOfAllId.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllId;
    }
}
