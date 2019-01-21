package com.eve.dao;

import com.eve.model.User;

public interface UserDAO {

    public void create(User user);

    public User read();


}
