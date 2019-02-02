package com.eve.dao;

import com.eve.model.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ManagerDAO {

    public void createNewManager(Manager manager);

    public List getAllId();

    public Manager getManager(String login, String password);

    public Manager getManagerById(int id);

    public Manager getManagerByLogin(String login);

    public HashMap<String, String> getMapOfLoginPassword();

    public ArrayList<String> getAllLogin();
}
