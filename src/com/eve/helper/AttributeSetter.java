package com.eve.helper;

import com.eve.dao.DAOFactory;
import com.eve.dao.ManagerDAO;

import java.util.ArrayList;
import java.util.List;

public class AttributeSetter {

    private List<Integer> listOfAllId;

    public int setCorrectId(){
        IdGenerator idGenerator = new IdGenerator();
        int id = 0;
        boolean correctId = false;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ManagerDAO managerDAO = factory.getManagerDAO();
        listOfAllId = managerDAO.getAllId();
        while(correctId == false) {
            id = idGenerator.getRandomId();
            if(listOfAllId.contains(id)){
                correctId = true;
            }
        }
        return id;
    }
}
