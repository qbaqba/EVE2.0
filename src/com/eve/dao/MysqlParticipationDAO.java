package com.eve.dao;

import com.eve.model.Participant;
import com.eve.model.Participation;
import com.eve.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlParticipationDAO implements ParticipationDAO {

    private static final String CREATE_NEW_PARTICIPATION = "INSERT INTO participation VALUES(?, ?);";
    private static final String GET_ALL_PARTICIPATION_FOR_PARTICIPANT = "SELECT * FROM participation WHERE participant_id=?;";

    public void createParticipation(Participation participation){
        int participantId = participation.getParticipantId();
        int eventId = participation.getEventId();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_PARTICIPATION);
            preparedStatement.setInt(1, participantId);
            preparedStatement.setInt(2, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Participation> getAllParticipationForParticipant(Participant participant){
        ArrayList<Participation> allParticipation = new ArrayList<>();
        int participantId = participant.getId();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PARTICIPATION_FOR_PARTICIPANT);
            preparedStatement.setInt(1, participantId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Participation participation = new Participation();
                participation.setParticipantId(participantId);
                participation.setEventId(resultSet.getInt(1));
                allParticipation.add(participation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allParticipation;
    }
}
