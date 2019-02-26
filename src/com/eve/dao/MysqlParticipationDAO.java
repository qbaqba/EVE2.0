package com.eve.dao;

import com.eve.model.Participation;
import com.eve.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlParticipationDAO implements ParticipationDAO {

    private static final String CREATE_NEW_PARTICIPATION = "INSERT INTO participation VALUES(?, ?);";

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
}
