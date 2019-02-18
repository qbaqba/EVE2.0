package com.eve.verifier;

import com.eve.model.EventCategory;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.eve.model.EventCategory.MUSIC;

public class EventInputConverter {

    private String ticketPrice;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String category;

    private Double convertedTicketPrice;
    private LocalDate convertedStartDate;
    private LocalDate convertedEndDate;
    private LocalTime convertedStartTime;
    private LocalTime convertedEndTime;
    private EventCategory convertedCategory;

    public EventInputConverter(String ticketPrice, String category){
        this.ticketPrice = ticketPrice;
        this.category = category;
    }

    public void setDate(String startDate, String endDate, String startTime, String endTime){
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public void convertFields(){
        setTicketPrice();
        setStartDate();
        setEndDate();
        setStartTime();
        setEndTime();
        setCategory();
    }

    public void setTicketPrice(){
        try{
            if(ticketPrice.contains(",")){
                String convertedStringTicketPrice = ticketPrice.replaceAll(",",".");
                convertedTicketPrice = Double.valueOf(convertedStringTicketPrice);
            }
            else{
                convertedTicketPrice = Double.valueOf(ticketPrice);
            }
            if(convertedTicketPrice <= 0){
                convertedTicketPrice = 0.0;
            }
        }
        catch (Exception e){
            convertedTicketPrice = null;
        }
    }

    @SuppressWarnings("Duplicates")
    public void setStartDate(){
        try{
            int year, month, day;
            year = Integer.parseInt(startDate.substring(0,4));
            month = Integer.parseInt(startDate.substring(5,7));
            day = Integer.parseInt(startDate.substring(8,10));
            convertedStartDate = LocalDate.of(year, month, day);
        }
        catch (Exception e){
            convertedStartDate = null;
        }
    }
    @SuppressWarnings("Duplicates")
    public void setEndDate(){
        try{
            int year, month, day;
            year = Integer.parseInt(endDate.substring(0,4));
            month = Integer.parseInt(endDate.substring(5,7));
            day = Integer.parseInt(endDate.substring(8,10));
            convertedEndDate = LocalDate.of(year, month, day);
        }
        catch (Exception e){
            convertedEndDate = null;
    }
    }

    @SuppressWarnings("Duplicates")
    public void setStartTime(){
        try {
            int hour, minute;
            hour = Integer.parseInt(startTime.substring(0,2));
            minute = Integer.parseInt(startTime.substring(3,5));
            convertedStartTime = LocalTime.of(hour, minute);
        }
        catch (Exception e){
            convertedStartTime = null;
        }
    }
    @SuppressWarnings("Duplicates")
    public void setEndTime(){
        try {
            int hour, minute;
            hour = Integer.parseInt(endTime.substring(0,2));
            minute = Integer.parseInt(endTime.substring(3,5));
            convertedEndTime = LocalTime.of(hour, minute);
        }
        catch (Exception e){
            convertedEndTime = null;
        }
    }

    public void setCategory(){
        try{
            convertedCategory = EventCategory.valueOf(category.toUpperCase());
        }
        catch (Exception e){
            convertedCategory = null;
        }
    }

    public Double getConvertedTicketPrice() {
        return convertedTicketPrice;
    }

    public LocalDate getConvertedStartDate() {
        return convertedStartDate;
    }

    public LocalDate getConvertedEndDate() {
        return convertedEndDate;
    }

    public LocalTime getConvertedStartTime() {
        return convertedStartTime;
    }

    public LocalTime getConvertedEndTime() {
        return convertedEndTime;
    }

    public EventCategory getConvertedCategory() {
        return convertedCategory;
    }
}
