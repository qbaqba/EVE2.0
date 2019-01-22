package com.eve.dao;

public class MysqlDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MysqlUserDAO();
    }

    @Override
    public ManagerDAO getManagerDAO() {
        return new MysqlManagerDAO();
    }

    public EventDAO getEventDAO(){
        return null;
    }
}
