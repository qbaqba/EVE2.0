package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.EventDAO;
import com.eve.dao.ParticipantDAO;
import com.eve.helper.IdGenerator;
import com.eve.model.Event;
import com.eve.model.Manager;
import com.eve.model.Participant;

import java.util.ArrayList;
import java.util.HashMap;


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
    @SuppressWarnings("Duplicates")
    public boolean checkLoginPassword(String login, String password){
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        HashMap<String, String> mapOfLoginPassword = participantDAO.getMapOfLoginPassword();
        if(mapOfLoginPassword.containsKey(login)){
            String testPassword = mapOfLoginPassword.get(login);
            if(testPassword.equals(password)) return true;
            else return false;
        }
        else return false;
    }

    public Participant getParticipantByParticipantId(int participantId){
        Participant participant;
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = daoFactory.getParticipantDAO();
        EventDAO eventDAO = daoFactory.getEventDAO();
        participant = participantDAO.getParticipantByParticipantId(participantId);
        participant.setListOfAllParticipantEvents(eventDAO.getAllEventsForParticpant(participant));
        return participant;
    }

    public Participant getParticipantByLogin(String login){
        Participant participant;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        EventDAO eventDAO = factory.getEventDAO();
        participant = participantDAO.getParticipantByLogin(login);
        participant.setListOfAllParticipantEvents(eventDAO.getAllEventsForParticpant(participant));
        return participant;
    }

    public ArrayList<Participant> getAllParticipantForEvent(Event event){
        ArrayList<Participant> allParticipants;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        allParticipants = participantDAO.getAllParticipantsForEvent(event);
        return allParticipants;
    }

    public ArrayList<Participant> getAllParticipantsForManager(Manager manager){
        ArrayList<Participant> allParticipants;
        DAOFactory factory = DAOFactory.getMysqlDAOFactory();
        ParticipantDAO participantDAO = factory.getParticipantDAO();
        allParticipants = participantDAO.getAllParticipantsForManager(manager);
        return allParticipants;
    }
}
