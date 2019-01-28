package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ManagerDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerService {

    public Manager checkManagerExist(String inputLogin, String inputPassword){
        Manager manager;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        HashMap<String, String> mapOfAllAccounts = managerDAO.getAllAccount();

        if(mapOfAllAccounts.containsKey(inputLogin)) {
            String password = mapOfAllAccounts.get(inputLogin);
            if (password.equals(inputPassword)) {
                manager = managerDAO.getManager(inputLogin, inputPassword);
                return manager;
            }
            else {
                return null;
            }
        }
        else{
            return null;
        }
    }

    public void addManager(String login, String password){
        Manager newManager = new Manager(login, password);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        IdGenerator idGenerator = new IdGenerator(managerDAO.getAllId());
        newManager.setId(idGenerator.selectCorrectId());
        managerDAO.create(newManager);
    }



}
