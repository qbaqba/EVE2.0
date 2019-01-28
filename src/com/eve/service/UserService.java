package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.UserDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.User;

public class UserService {

    public void addUser(String login, String password){
        User user = new User(login, password);
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        IdGenerator idGenerator = new IdGenerator(userDAO.getAllId());
        user.setId(idGenerator.selectCorrectId());
        userDAO.create(user);
    }
}


