package com.eve.dao;

import com.eve.model.Participant;

public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();
    public abstract ManagerDAO getManagerDAO();
    public abstract EventDAO getEventDAO();
    public abstract ParticipantDAO getParticipantDAO();

    public static DAOFactory getMysqlDAOFactory(){
        return new MysqlDAOFactory();
    }

}
