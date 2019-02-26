package com.eve.dao;

public class MysqlDAOFactory extends DAOFactory {

    @Override
    public ManagerDAO getManagerDAO() {
        return new MysqlManagerDAO();
    }

    public EventDAO getEventDAO(){
        return new MysqlEventDAO();
    }

    public ParticipantDAO getParticipantDAO(){
        return new MysqlParticipantDAO();
    }

    public ParticipationDAO getParticipationDAO(){return new MysqlParticipationDAO(); }
}
