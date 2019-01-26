package com.eve.dao;

import com.eve.model.Event;

import java.util.List;

public interface EventDAO {
    public void create(Event event);
    public List getAllId();
}
