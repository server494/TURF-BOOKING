package com.arjuncode.turfbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequestDTO {

    private Long customerId;
    private Long turfId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    // endTime OPTIONAL if auto-calculated
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    private BigDecimal durationInHours;

    // getters & setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTurfId() {
        return turfId;
    }

    public void setTurfId(Long turfId) {
        this.turfId = turfId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(BigDecimal durationInHours) {
        this.durationInHours = durationInHours;
    }

}
