package com.eve.dao;

import com.eve.model.User;

import java.util.List;

public interface UserDAO {

    public void create(User user);

    public User read();

    public List getAllId();


}
