package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.ParticipantDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Participant;

import java.util.ArrayList;


public class ParticipantService {

    public boolean checkLoginAvailability(String login){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        ArrayList<String> listOfAllLogin = participantDAO.getAllLogin();
        if(listOfAllLogin.contains(login)) return false;
        else return true;
    }

    public void createNewParticipant(String login, String password){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        Participant participant = new Participant(login, password);
        IdGenerator idGenerator = new IdGenerator(participantDAO.getAllId());
        participant.setId(idGenerator.selectCorrectId());
        participantDAO.createNewParticipant(participant);
    }
}
