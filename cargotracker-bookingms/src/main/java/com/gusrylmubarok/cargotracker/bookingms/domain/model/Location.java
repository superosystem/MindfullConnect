package com.gusrylmubarok.cargotracker.bookingms.domain.model;

public class Location {
    private String unLocCode;

    public Location(String unLocCode) {
        this.unLocCode = unLocCode;
    }

    public String getUnLocCode() {
        return unLocCode;
    }

    public void setUnLocCode(String unLocCode) {
        this.unLocCode = unLocCode;
    }
}
