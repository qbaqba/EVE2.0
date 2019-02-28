package com.eve.model;

import java.util.ArrayList;

public class Participant {

    private static final AccountType accountType = AccountType.PARTICIPANT;

    private int id;
    private String login;
    private String password;

    private ArrayList<Event> listOfAllParticipantEvents;
    private ArrayList<Manager> listOfSubscribedMangers;

    public Participant(){ }

    public Participant(String login, String password){
        this.login = login;
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setListOfAllParticipantEvents(ArrayList<Event> listOfAllParticipantEvents) {
        this.listOfAllParticipantEvents = listOfAllParticipantEvents;
    }

    public ArrayList<Event> getListOfAllParticipantEvents() {
        return listOfAllParticipantEvents;
    }

    public void setListOfSubscribedMangers(ArrayList<Manager> listOfSubscribedMangers) {
        this.listOfSubscribedMangers = listOfSubscribedMangers;
    }

    public ArrayList<Manager> getListOfSubscribedMangers() {
        return listOfSubscribedMangers;
    }
}
