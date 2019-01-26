package com.eve.model;

public class Event {

    private int id;
    private String name;
    private String location;

    private int usersCounter;
    private Manager manager;

    public Event(String name, String location, Manager manager){
        this.name = name;
        this.location = location;
        this.manager = manager;
        usersCounter = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersCounter() {
        return usersCounter;
    }

    public void setUsersCounter(int usersCounter) {
        this.usersCounter = usersCounter;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
