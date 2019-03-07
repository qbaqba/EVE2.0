package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.dao.ManagerDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerService {


    public boolean checkLoginAvailability(String login){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        ArrayList<String> listOfAllLogin = managerDAO.getAllLogin();
        if(listOfAllLogin.contains(login)) return false;
        else return true;
    }

    public void createNewManager(String login, String password){
        Manager newManager = new Manager(login, password);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        IdGenerator idGenerator = new IdGenerator(managerDAO.getAllId());
        newManager.setId(idGenerator.selectCorrectId());
        managerDAO.createNewManager(newManager);
    }
    @SuppressWarnings("Duplicates")
    public boolean checkLoginPassword(String login, String password){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        HashMap<String, String> mapOfLoginPassword = managerDAO.getMapOfLoginPassword();
        if(mapOfLoginPassword.containsKey(login)){
            String testPassword = mapOfLoginPassword.get(login);
            if(testPassword.equals(password)) return true;
            else return false;
        }
        else return false;
    }

    public Manager getManagerByLogin(String login){
        Manager manager;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        EventDAO eventDAO = factory.getEventDAO();
        manager = managerDAO.getManagerByLogin(login);
        manager.setListOfCreatedEvents(eventDAO.getAllEventsCreatedByManager(manager));
        return manager;
    }

    public Manager getManagerByManagerId(int id){
        Manager manager;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        manager = managerDAO.getManagerByManagerId(id);
        return manager;
    }



}
