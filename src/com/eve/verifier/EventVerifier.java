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

    public void setEventInputConverter(){
        eventInputConverter = new EventInputConverter(ticketPrice, category);
        eventInputConverter.setDate(startDate, endDate, startTime, endTime);
        eventInputConverter.convertFields();
    }


    public void setIsCorrectInput(){
        int sumOfTrueConditions = 0;
        if(checkName() == true && checkLocation() == true && checkDescription() == true){
            sumOfTrueConditions++;
        }
        if(checkTicketPrice() == true && checkDate() == true && checkCategory() == true){
            sumOfTrueConditions++;
        }
        if(sumOfTrueConditions == 2) isCorrectInput = true;
        else isCorrectInput = false;
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
        return name.length() <= 45 && name.length() >= 1 && name != null;
    }

    private boolean checkLocation(){
        return location.length() <= 45 && location.length() >= 1 && location != null;
    }

    private boolean checkDescription(){
        return description.length() <= 2048;
    }

    private boolean checkTicketPrice(){
        return eventInputConverter.getConvertedTicketPrice() != null;
    }

    private boolean checkDate(){
        boolean isCorrectDate = false;
        int sumOfTrueConditions = 0;
        if(eventInputConverter.getConvertedStartDate() != null && eventInputConverter.getConvertedEndDate() != null){
            sumOfTrueConditions++;
        }
        if(eventInputConverter.getConvertedStartTime() != null && eventInputConverter.getConvertedEndTime() != null){
            sumOfTrueConditions++;
        }

        if(sumOfTrueConditions == 2){
            LocalDateTime startFullDate = LocalDateTime.of(eventInputConverter.getConvertedStartDate(), eventInputConverter.getConvertedStartTime());
            LocalDateTime endFullDate = LocalDateTime.of(eventInputConverter.getConvertedEndDate(), eventInputConverter.getConvertedEndTime());
            if((startFullDate.isBefore(endFullDate) || startFullDate.equals(endFullDate)) && (startFullDate.isAfter(LocalDateTime.now()))){
                isCorrectDate = true;
            }
            else isCorrectDate = false;
        }
        return isCorrectDate;
    }

    private boolean checkCategory(){
        return eventInputConverter.getConvertedCategory() != null;
    }

    @Override
    boolean isCorrectInput() {
        return isCorrectInput;
    }
}
