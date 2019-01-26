package com.eve.dao;

import com.eve.model.Manager;

import java.util.List;

public interface ManagerDAO {

    public void create(Manager manager);

    public List getAllId();

    public List getAllLogin();

    public List getAllPassword();

    public Manager getManager(String login, String password);
}
