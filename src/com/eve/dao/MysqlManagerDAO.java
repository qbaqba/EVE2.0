package com.eve.dao;

import com.eve.model.Manager;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MysqlManagerDAO implements ManagerDAO {

    private static final String CREATE_MANAGER_SQL_QUERRY = "INSERT INTO MANAGER VALUES(?, ?, ?);";
    private static final String SELECT_MANAGER_BY_LOGIN = "SELECT * FROM manager WHERE manager_login=?;";
    private static final String SELECT_ALL_LOGINS = "SELECT manager_login FROM manager;";
    private static final String GET_MANAGER_BY_MANAGER_ID = "SELECT * FROM manager WHERE manager_id=?;";




    @Override
    @SuppressWarnings("Duplicates")
    public void createNewManager(Manager manager) {
        int id = manager.getId();
        String login = manager.getLogin();
        String password = manager.getPassword();

        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MANAGER_SQL_QUERRY);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // this method returns ArrayList with all manager login from database
    public ArrayList<String> getAllLogin() {
        ArrayList<String> listOfLogins = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_LOGINS);
            while (resultSet.next()) {
                listOfLogins.add(resultSet.getString("manager_login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfLogins;
     }

    public HashMap<String, String> getMapOfLoginPassword() {
        HashMap<String, String> mapOfLoginPassword= new HashMap<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT manager_login, manager_password FROM manager;");
            while(resultSet.next()){
                String login = resultSet.getString("manager_login");
                String password = resultSet.getString("manager_password");
                mapOfLoginPassword.put(login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapOfLoginPassword;
    }

    @Override
    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> listOfAllId = new ArrayList<Integer>();

        try{
            Connection connection = ConnectionProvider.getConnection();
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

    @Override
    public Manager getManager(String login, String password) {
        return null;
    }

    public Manager getManagerByEventId(int eventId){
        String query1 = "SELECT manager_id FROM event WHERE event_id=?;";
        String query2 = "SELECT * FROM manager WHERE manager_id=?;";
        int managerId = 0;
        Manager manager = new Manager();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setInt(1, eventId);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            resultSet1.next();
            managerId = resultSet1.getInt("manager_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, managerId);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();
            manager.setId(resultSet2.getInt("manager_id"));
            manager.setLogin(resultSet2.getString("manager_login"));
            manager.setPassword(resultSet2.getString("manager_password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public Manager getManagerByManagerId(int managerId) {
        Manager manager = new Manager();
        try{
            DAOFactory factory = DAOFactory.getMysqlDAOFactory();
            EventDAO eventDAO = factory.getEventDAO();
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MANAGER_BY_MANAGER_ID);
            preparedStatement.setInt(1, managerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            manager.setId(resultSet.getInt("manager_id"));
            manager.setLogin(resultSet.getString("manager_login"));
            manager.setPassword(resultSet.getString("manager_password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
    @SuppressWarnings("Duplicates")
    @Override
    public Manager getManagerByLogin(String login) {
        Manager manager = null;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MANAGER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int managerId = resultSet.getInt("manager_id");
            String managerLogin = resultSet.getString("manager_login");
            String managerPassword = resultSet.getString("manager_password");
            manager = new Manager(managerLogin, managerPassword);
            manager.setId(managerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

}
