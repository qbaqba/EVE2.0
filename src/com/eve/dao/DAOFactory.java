package com.eve.dao;

public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();
    public abstract ManagerDAO getManagerDAO();
    public abstract EventDAO getEventDAO();


}
