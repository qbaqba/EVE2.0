package com.eve.dao;

import com.eve.model.Participant;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MysqlParticipantDAO implements ParticipantDAO {

    // MYSQL QUERIES
    private static final String SELECT_ALL_LOGINS = "SELECT participant_login FROM participant;";
    private static final String INSERT_NEW_PARTICIPANT = "INSERT INTO participant VALUES(?, ?, ?);";




    @SuppressWarnings("Duplicates")
    @Override
    public void createNewParticipant(Participant participant) {
        int id = participant.getId();
        String login = participant.getLogin();
        String password = participant.getPassword();

        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PARTICIPANT);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLogin(String login) {
        return false;
    }

    @Override
    public HashMap<String, String> mapOfLoginPassword() {
        return null;
    }

    // this method returns ArrayList with all participants login from database
    public ArrayList<String> getAllLogin() {
        ArrayList<String> listOfLogins = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_LOGINS);
            while (resultSet.next()){
                listOfLogins.add(resultSet.getString("participant_login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfLogins;
    }
}
