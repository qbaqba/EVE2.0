package com.eve.dao;

import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;

import java.util.ArrayList;
import java.util.HashMap;

public interface ParticipantDAO {

    public void createNewParticipant(Participant participant);

    public Participant getParticipantByLogin(String login);

    public Participant getParticipantByParticipantId(int participantId);

    public HashMap<String, String> getMapOfLoginPassword();

    public ArrayList<String> getAllLogin();

    public ArrayList<Integer> getAllId();

    public ArrayList<Participant> getAllParticipantsForEvent(Event event);

    public ArrayList<Participant> getAllParticipantsForManager(Manager manager);
}
