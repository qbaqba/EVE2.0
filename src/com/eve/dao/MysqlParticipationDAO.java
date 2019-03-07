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
    private static final String DELETE_PARTICIPATION = "DELETE FROM participation WHERE participant_id=? AND event_id=?;";

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

    public void deleteParticipation(Participation participation){
        int participantId = participation.getParticipantId();
        int eventId = participation.getEventId();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PARTICIPATION);
            preparedStatement.setInt(1, participantId);
            preparedStatement.setInt(2, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
