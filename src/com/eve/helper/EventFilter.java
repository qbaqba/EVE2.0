package com.eve.helper;

import java.time.LocalDate;

public class EventFilter {

    private String[] categories;
    private double minTicketPrice;
    private double maxTicketPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public EventFilter(){}

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setMinTicketPrice(double minTicketPrice) {
        this.minTicketPrice = minTicketPrice;
    }

    public double getMinTicketPrice() {
        return minTicketPrice;
    }

    public void setMaxTicketPrice(double maxTicketPrice) {
        this.maxTicketPrice = maxTicketPrice;
    }

    public double getMaxTicketPrice() {
        return maxTicketPrice;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
