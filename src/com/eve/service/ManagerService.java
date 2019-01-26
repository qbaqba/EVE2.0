package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ManagerDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerService {

    public void addManager(String login, String password){
        Manager newManager = new Manager(login, password);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        IdGenerator idGenerator = new IdGenerator(managerDAO.getAllId());
        newManager.setId(idGenerator.selectCorrectId());
        managerDAO.create(newManager);
    }

    public Manager getManager(String login, String password){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();

        ArrayList<String> listOfAllLogin = (ArrayList<String>) managerDAO.getAllLogin();
        ArrayList<String> listOfAllPassword = (ArrayList<String>) managerDAO.getAllPassword();
        if(listOfAllLogin.contains(login) && listOfAllPassword.contains(password)){
            Manager manager = managerDAO.getManager(login, password);
            return manager;
        }
        else{
            return null;
        }

    }


}
