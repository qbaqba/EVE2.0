package com.eve.dao;

import com.eve.model.Participant;
import com.eve.model.Participation;

import java.util.ArrayList;

public interface ParticipationDAO {
    public void createParticipation(Participation participation);
    public void deleteParticipation(Participation participation);
}
