package com.eve.dao;

import com.eve.model.Subscription;

public interface SubscriptionDAO{

    public void createSubscription(Subscription subscription);
    public void deleteSubscription(Subscription subscription);
}
