package com.eve.dao;

import com.eve.model.Participant;

public abstract class DAOFactory {

    public abstract ManagerDAO getManagerDAO();
    public abstract EventDAO getEventDAO();
    public abstract ParticipantDAO getParticipantDAO();
    public abstract ParticipationDAO getParticipationDAO();
    public abstract SubscriptionDAO getSubscriptionDAO();

    public static DAOFactory getMysqlDAOFactory(){
        return new MysqlDAOFactory();
    }

}
