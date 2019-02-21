package com.eve.helper.converter;

import com.eve.model.Event;
import com.eve.model.EventCategory;
import com.eve.model.Manager;

import java.time.LocalDateTime;

public class EventConverter extends Event {

    private String ticketPrice;
    private String category;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    public EventConverter(String ticketPrice, String category, Manager manager){
        this.ticketPrice = ticketPrice;
        this.category = category;
        super.setManager(manager);
    }

    public void setNotConvertedFields(String name, String location, String description){
        super.setName(name);
        super.setLocation(location);
        super.setDescription(description);
    }

    public void setDate(String startDate, String endDate, String startTime, String endTime){
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setConvertedFields(){
        setTicketPrice();
        setCategory();
        setStartDateTime();
        setEndDateTime();
    }

    public void setTicketPrice(){
        String convertedStringTicketPrice = ticketPrice.replaceAll(",",".");
        double convertedTicketPrice = Double.valueOf(convertedStringTicketPrice);
        super.setTicketPrice(convertedTicketPrice);
    }

    public void setCategory(){
        EventCategory eventCategory = EventCategory.valueOf(category.toUpperCase());
        super.setCategory(eventCategory);
    }
    @SuppressWarnings("Duplicates")
    public void setStartDateTime(){
        int year, month, day, hour, minute;
        LocalDateTime startDateTime;
        year = Integer.parseInt(startDate.substring(0,4));
        month = Integer.parseInt(startDate.substring(5,7));
        day = Integer.parseInt(startDate.substring(8,10));
        hour = Integer.parseInt(startTime.substring(0,2));
        minute = Integer.parseInt(startTime.substring(3,5));
        startDateTime = LocalDateTime.of(year,month,day,hour,minute);
        super.setStartDate(startDateTime);
    }
    @SuppressWarnings("Duplicates")
    public void setEndDateTime(){
        int year, month, day, hour, minute;
        LocalDateTime endDateTime;
        year = Integer.parseInt(endDate.substring(0,4));
        month = Integer.parseInt(endDate.substring(5,7));
        day = Integer.parseInt(endDate.substring(8,10));
        hour = Integer.parseInt(endTime.substring(0,2));
        minute = Integer.parseInt(endTime.substring(3,5));
        endDateTime = LocalDateTime.of(year,month,day,hour,minute);
        super.setEndDate(endDateTime);
    }

    public Event getNewEvent(){
        Event newEvent = new Event();
        return newEvent;
    }




}
