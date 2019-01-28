package com.eve.dao;

import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MysqlManagerDAO implements ManagerDAO {

    private static final String CREATE_MANAGER_SQL_QUERRY = "INSERT INTO MANAGER VALUES(?, ?, ?);";

    private static final String GET_MANAGER_SQL_QUERRY = "SELECT id from manager where login=? and password=?;";
    private static final String GET_MANAGER_BY_ID_SQL_QUERY = "SELECT * FROM manager where id=?;";

    private static final String GET_ALL_ACCOUNT_SQL_QUERRY = "SELECT login, password FROM manager;";


    @Override
    @SuppressWarnings("Duplicates")
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

    public Manager getManager(String login, String password) {
        Manager manager = new Manager(login, password);
        int id = 0;
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MANAGER_SQL_QUERRY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            manager.setId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public Manager getManagerById(int id) {
        Manager manager = null;
        String idString = String.valueOf(id);
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MANAGER_BY_ID_SQL_QUERY);
            preparedStatement.setString(1,idString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                manager = new Manager(login, password);
                manager.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }


    @Override
    public HashMap<String, String> getAllAccount() {
        HashMap<String, String> mapOfAllAccount = new HashMap<>();

        try (Connection connection = ConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_ACCOUNT_SQL_QUERRY);
            while(resultSet.next()){
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                mapOfAllAccount.put(login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapOfAllAccount;
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
