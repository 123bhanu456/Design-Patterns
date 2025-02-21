package com.Spring.CarRental.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "BookingTimeDetails")
public class BookingTimeDetails {

    private String bookingId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double amount;

    public BookingTimeDetails(String bookingId, LocalDateTime startTime) {
        this.bookingId = bookingId;
        this.startTime = startTime;
        this.endTime = null;
        this.amount = 0.0;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}