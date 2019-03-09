package com.eve.service;

import com.eve.dao.DAOFactory;
import com.eve.dao.SubscriptionDAO;
import com.eve.model.Subscription;

public class SubscriptionService {

    public void createSubscription(int participantId, int managerId){
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        SubscriptionDAO subscriptionDAO = daoFactory.getSubscriptionDAO();
        Subscription subscription = new Subscription(participantId, managerId);
        subscriptionDAO.createSubscription(subscription);
    }

    public void deleteSubscription(int participantId, int managerId){
        DAOFactory daoFactory = DAOFactory.getMysqlDAOFactory();
        SubscriptionDAO subscriptionDAO = daoFactory.getSubscriptionDAO();
        Subscription subscription = new Subscription(participantId, managerId);
        subscriptionDAO.deleteSubscription(subscription);
    }

}
