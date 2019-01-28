package com.eve.dao;

import com.eve.model.User;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlUserDAO implements UserDAO {

    private static final String CREATE_USER_SQL_QUERRY = "INSERT INTO user VALUES(?, ?, ?);";
    @SuppressWarnings("Duplicates")
    @Override
    public void create(User user) {
    int id = user.getId();
    String login = user.getLogin();
    String password = user.getPassword();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_SQL_QUERRY);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3,password);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read() {
        return null;
    }

    @Override
    public List getAllId() {
        ArrayList<Integer> listOfAllId = new ArrayList<Integer>();

        try (Connection connection = ConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM user;");
            while(resultSet.next()){
                listOfAllId.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllId;
    }
}
