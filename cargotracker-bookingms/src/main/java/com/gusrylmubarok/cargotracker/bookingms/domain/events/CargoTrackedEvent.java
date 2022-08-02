package com.gusrylmubarok.cargotracker.bookingms.domain.events;

public class CargoTrackedEvent {
    private String bookingId;
    private String trackingId;

    public CargoTrackedEvent(String bookingId,String trackingId){
        this.bookingId = bookingId;
        this.trackingId = trackingId;
    }

    public String getBookingId(){ return this.bookingId; }
    public void setBookingId(String bookingId){this.bookingId = bookingId;}

    public String getTrackingId(){return this.trackingId;}
    public void setTrackingId(String trackingId){this.trackingId = trackingId;}
}
