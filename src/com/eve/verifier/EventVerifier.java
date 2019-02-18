package com.eve.verifier;

import com.eve.model.EventCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventVerifier extends InputVerifier {

    private String name;
    private String location;
    private String description;
    private String ticketPrice;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String category;

    private EventInputConverter eventInputConverter;

    private LocalDate convertedStartDate;
    private LocalDate convertedEndDate;

    public void setConvertedStartDate() {
      //  convertedStartDate = LocalDate.of();
    }

    private double convertedToDoubleTicketPrice;
    private boolean isCorrectInput;

    public EventVerifier(){}

    public EventVerifier(String name, String location, String description, String ticketPrice){
        this.name = name;
        this.location = location;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }

    public void setDate(String startDate, String startTime, String endDate, String endTime){
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }


    public void setIsCorrectInput(){

    }

    public double getConvertedToDoubleTicketPrice() {
        return convertedToDoubleTicketPrice;
    }

    public void setConvertedToDoubleTicketPrice(double convertedToDoubleTicketPrice) {
        this.convertedToDoubleTicketPrice = convertedToDoubleTicketPrice;
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

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    private boolean checkName(){
        if(name.length() > 45 || name.length() < 1 || name == null){
            return false;
        }
        else return true;
    }

    private boolean checkLocation(){
        if(location.length() > 45 || location.length() < 1 || location == null){
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

    private boolean checkTicketPrice(){
        String convertedTicketPrice;
        try{
            convertedTicketPrice = ticketPrice.replaceAll(",", ".");
            convertedToDoubleTicketPrice = Double.parseDouble(convertedTicketPrice);
            if(convertedToDoubleTicketPrice <= 0){
                convertedToDoubleTicketPrice = 0;
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private boolean checkDate(){
        return true;
    }

    @Override
    boolean isCorrectInput() {
        return isCorrectInput;
    }
}
