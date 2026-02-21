package com.arjuncode.turfbooking.dto;

import java.math.BigDecimal;

public class TurfResponseDTO {

    private Long id;
    private String turfName;
    private String location;
    private String pricePerHour;

    public void setPricePerHour(BigDecimal price) {
        this.pricePerHour = price.toPlainString();
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurfName() {
        return turfName;
    }

    public void setTurfName(String turfName) {
        this.turfName = turfName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
