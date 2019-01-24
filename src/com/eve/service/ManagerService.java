package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ManagerDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Manager;

public class ManagerService {

    public void addManager(String login, String password){
        Manager newManager = new Manager(login, password);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        IdGenerator idGenerator = new IdGenerator(managerDAO.getAllId());
        newManager.setId(idGenerator.selectCorrectId());
        managerDAO.create(newManager);
    }


}
