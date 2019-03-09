package com.eve.dao;

import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;
import com.eve.util.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MysqlParticipantDAO implements ParticipantDAO {



    // MYSQL QUERIES
    private static final String SELECT_ALL_ID = "SELECT participant_id FROM participant;";
    private static final String SELECT_ALL_LOGINS = "SELECT participant_login FROM participant;";
    private static final String INSERT_NEW_PARTICIPANT = "INSERT INTO participant VALUES(?, ?, ?);";
    private static final String SELECT_PARTICIPANT_BY_LOGIN = "SELECT * FROM participant WHERE participant_login=?;";
    private static final String GET_PARTICIPANT_BY_ID = "SELECT * FROM participant WHERE participant_id=?;";




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
    public Participant getParticipantByLogin(String login) {
        Participant participant = null;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARTICIPANT_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int participantId = resultSet.getInt("participant_id");
            String participantLogin = resultSet.getString("participant_login");
            String participantPassword = resultSet.getString("participant_password");
            participant = new Participant(participantLogin, participantPassword);
            participant.setId(participantId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participant;
    }

    public Participant getParticipantByParticipantId(int participantId){
        Participant participant = new Participant();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PARTICIPANT_BY_ID);
            preparedStatement.setInt(1, participantId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            participant.setId(resultSet.getInt("participant_id"));
            participant.setLogin(resultSet.getString("participant_login"));
            participant.setPassword(resultSet.getString("participant_password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participant;
    }

    public ArrayList<Participant> getAllParticipantsForEvent(Event event){
        ArrayList<Participant> allParticipantsForEvent;
        ArrayList<Integer> allParticipantIdForEvent = getAllParticpantIdForEvent(event);
        allParticipantsForEvent = getAllParticipantFromParticipantId(allParticipantIdForEvent);
        return allParticipantsForEvent;
    }
    /////////////////////////////////////////////////////////////////////


    public ArrayList<Integer> getAllParticpantIdForEvent(Event event){
        ArrayList<Integer> allParticipantIdforEvent = new ArrayList<>();
        String query = "SELECT participant_id FROM participation WHERE event_id=?;";
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, event.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int participantId = resultSet.getInt("participant_id");
                allParticipantIdforEvent.add(participantId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allParticipantIdforEvent;
    }

    public ArrayList<Participant> getAllParticipantsForManager(Manager manager){
        ArrayList<Participant> allParticipants;
        ArrayList<Integer> allParticipantIdForManager = getAllParticipantIdForManager(manager);
        allParticipants = getAllParticipantFromParticipantId(allParticipantIdForManager);
        return allParticipants;
    }



    public ArrayList<Integer> getAllParticipantIdForManager(Manager manager){
        ArrayList<Integer> allParticipantIdforManager = new ArrayList<>();
        String query = "SELECT participant_id FROM subscription WHERE manager_id=?;";
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, manager.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int participantId = resultSet.getInt("participant_id");
                allParticipantIdforManager.add(participantId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allParticipantIdforManager;
    }
    public ArrayList<Participant> getAllParticipantFromParticipantId(ArrayList<Integer> allParticipantId){
        ArrayList<Participant> allParticipants = new ArrayList<>();
        String query = "SELECT * FROM participant WHERE participant_id=?;";
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(int participantId : allParticipantId){
                preparedStatement.setInt(1, participantId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    Participant participant = new Participant();
                    participant.setId(resultSet.getInt("participant_id"));
                    participant.setLogin(resultSet.getString("participant_login"));
                    participant.setPassword(resultSet.getString("participant_password"));
                    allParticipants.add(participant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allParticipants;
    }

    @Override
    public HashMap<String, String> getMapOfLoginPassword() {
        HashMap<String, String> mapOfLoginPassword = new HashMap<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT participant_login, participant_password FROM participant;");
            while(resultSet.next()){
                String login = resultSet.getString("participant_login");
                String password = resultSet.getString("participant_password");
                mapOfLoginPassword.put(login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapOfLoginPassword;
    }

    // this method returns ArrayList with all participants login from database
    public ArrayList<String> getAllLogin() {
        ArrayList<String> listOfLogins = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
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
    // this method returns ArrayList with all participants id from database
    public ArrayList<Integer> getAllId(){
        ArrayList<Integer> listOfAllId = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ID);
            while(resultSet.next()){
                listOfAllId.add(resultSet.getInt("participant_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllId;
    }


}
