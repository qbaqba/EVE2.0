package com.eve.verifier;

import com.eve.model.EventCategory;

import java.time.LocalDateTime;

public class EventVerifier extends InputVerifier {

    private String name;
    private String location;
    private String description;
    private double ticketPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public EventVerifier(String name, String location, String description, double ticketPrice){
        this.name = name;
        this.location = location;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }

    private boolean checkName(){
        if(name.length()>45 || name.length()<3){
            return false;
        }
        else return true;
    }

    private boolean checkLocation(){
        if(location.length()>45 || location.length()<3 ){
            return false;
        }
        else return true;
    }

    private boolean checkDescription(){
        if(description.length()>2048 ){
            return false;
        }
        else return true;
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
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


    @Override
    boolean isCorrectInput() {
        return false;
    }
}
