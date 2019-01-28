package com.eve.dao;

import com.eve.model.Manager;

import java.util.HashMap;
import java.util.List;

public interface ManagerDAO {

    public void create(Manager manager);

    public List getAllId();

    public Manager getManager(String login, String password);

    public Manager getManagerById(int id);

    public HashMap<String, String> getAllAccount();
}
