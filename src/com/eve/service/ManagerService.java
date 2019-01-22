package com.eve.service;

import com.eve.dao.MysqlManagerDAO;
import com.eve.helper.AttributeSetter;
import com.eve.model.Manager;

public class ManagerService {

    public void addManager(String login, String password){
        Manager newManager = new Manager(login, password);
        newManager.setId(AttributeSetter.setCorrectId());
    }


}
