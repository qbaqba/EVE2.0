package com.eve.model;

public class Subscription {

    private int managerId;
    private int participantId;

    public Subscription(){}

    public Subscription(int participantId, int managerId){
        this.participantId = participantId;
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }
}
