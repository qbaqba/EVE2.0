package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ParticipationDAO;
import com.eve.model.Participation;

public class ParticipationService {

    public void createParticipation(String participantId, String eventId){
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        ParticipationDAO participationDAO = daoFactory.getParticipationDAO();
        int convertedParticipantId = Integer.parseInt(participantId);
        int convertedEventId = Integer.parseInt(eventId);
        Participation participation = new Participation(convertedParticipantId, convertedEventId);
        participationDAO.createParticipation(participation);
    }

}
