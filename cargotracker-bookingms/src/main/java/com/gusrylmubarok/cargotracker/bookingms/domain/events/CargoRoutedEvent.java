package com.gusrylmubarok.cargotracker.bookingms.domain.events;

import com.gusrylmubarok.cargotracker.bookingms.domain.model.Itinerary;
/*
** Event that gets generated when cargo is routed
 */
public class CargoRoutedEvent {
    private String bookingId;
    private Itinerary itinerary;

    public CargoRoutedEvent(String bookingId, Itinerary itinerary) {
        this.bookingId = bookingId;
        this.itinerary = itinerary;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }
}
