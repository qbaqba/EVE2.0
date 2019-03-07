package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ParticipationDAO;
import com.eve.model.Participant;
import com.eve.model.Participation;

import java.util.ArrayList;

public class ParticipationService {

    public void createParticipation(int participantId, int eventId){
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        ParticipationDAO participationDAO = daoFactory.getParticipationDAO();
        Participation participation = new Participation(participantId, eventId);
        participationDAO.createParticipation(participation);
    }

    public void deleteParticipation(int participantId, int eventId){
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        ParticipationDAO participationDAO = daoFactory.getParticipationDAO();
        Participation participation = new Participation(participantId, eventId);
        participationDAO.deleteParticipation(participation);
    }

}
