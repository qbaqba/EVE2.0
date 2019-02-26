package com.eve.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {

    // required parameters
    private int id;
    private String name;
    private String location;
    private String description;
    private Double ticketPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createDate;
    private EventCategory category;
    private Manager manager;
    private ArrayList<Participant> listOfAllParticipants;

   public Event(){}

   public Event(Event event){
       this.id = event.id;
       this.name = event.name;
       this.location = event.location;
       this.description = event.description;
       this.ticketPrice = event.ticketPrice;
       this.startDate = event.startDate;
       this.endDate = event.endDate;
       this.createDate = event.createDate;
       this.category = event.category;
       this.manager = event.manager;
       this.listOfAllParticipants = event.listOfAllParticipants;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreateDate(){return createDate;}

    public void setCreateDate(LocalDateTime createDate){this.createDate = createDate;}

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Participant> getListOfAllParticipants() {
        return listOfAllParticipants;
    }

    public void setListOfAllParticipants(ArrayList<Participant> listOfAllParticipants) {
        this.listOfAllParticipants = listOfAllParticipants;
    }
}
