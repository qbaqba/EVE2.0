package com.eve.dao;

import com.eve.model.Participant;

import java.util.ArrayList;
import java.util.HashMap;

public interface ParticipantDAO {

    public void createNewParticipant(Participant participant);

    public Participant getParticipantByLogin(String login);

    public HashMap<String, String> getMapOfLoginPassword();

    public ArrayList<String> getAllLogin();

    public ArrayList<Integer> getAllId();
}
