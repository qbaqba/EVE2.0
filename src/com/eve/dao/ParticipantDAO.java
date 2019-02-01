package com.eve.dao;

import com.eve.model.Participant;

import java.util.ArrayList;
import java.util.HashMap;

public interface ParticipantDAO {

    public void createNewParticipant(Participant participant);

    public boolean checkLogin(String login);

    public HashMap<String, String> mapOfLoginPassword();

    public ArrayList<String> getAllLogin();

    public ArrayList<Integer> getAllId();
}
