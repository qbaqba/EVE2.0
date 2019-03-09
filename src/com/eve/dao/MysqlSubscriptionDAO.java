package com.eve.dao;

import com.eve.model.Subscription;
import com.eve.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlSubscriptionDAO implements SubscriptionDAO {

    private static final String CREATE_NEW_SUBSCRIPTION = "INSERT INTO subscription VALUES(?, ?);";
    private static final String DELETE_SUBSCRIPTION = "DELETE FROM subscription WHERE participant_id=? AND manager_id=?;";

    public void createSubscription(Subscription subscription){
        int participantId = subscription.getParticipantId();
        int managerId = subscription.getManagerId();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_SUBSCRIPTION);
            preparedStatement.setInt(1, participantId);
            preparedStatement.setInt(2, managerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubscription(Subscription subscription){
        int participantId = subscription.getParticipantId();
        int managerId = subscription.getManagerId();

        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SUBSCRIPTION);
            preparedStatement.setInt(1, participantId);
            preparedStatement.setInt(2, managerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
