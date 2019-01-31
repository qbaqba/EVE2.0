package com.eve.model;

import java.util.ArrayList;

public class Manager {

    private int id;
    private String login;
    private String password;

    private ArrayList<Event> listOfCreatedEvents;
    private ArrayList<Participant> listOfFollowers;

    public Manager(){};

    public Manager(Manager manager){
        this.id = manager.id;
        this.login = manager.login;
        this.password = manager.password;
        this.listOfCreatedEvents = manager.listOfCreatedEvents;
        this.listOfFollowers = manager.listOfFollowers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Event> getListOfCreatedEvents() {
        return listOfCreatedEvents;
    }

    public void setListOfCreatedEvents(ArrayList<Event> listOfCreatedEvents) {
        this.listOfCreatedEvents = listOfCreatedEvents;
    }

    public ArrayList<Participant> getListOfFollowers() {
        return listOfFollowers;
    }

    public void setListOfFollowers(ArrayList<Participant> listOfFollowers) {
        this.listOfFollowers = listOfFollowers;
    }
}
