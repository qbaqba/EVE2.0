package com.eve.model;

public class Participation {

    private int participantId;
    private int eventId;

    public Participation(){}

    public Participation(int participantId, int eventId){
        this.participantId = participantId;
        this.eventId = eventId;
    }

    public void setParticipantId(int participantId){
        this.participantId = participantId;
    }
    public int getParticipantId(){
        return participantId;
    }

    public void setEventId(int eventId){
        this.eventId = eventId;
    }
    public int getEventId(){
        return eventId;
    }
}
