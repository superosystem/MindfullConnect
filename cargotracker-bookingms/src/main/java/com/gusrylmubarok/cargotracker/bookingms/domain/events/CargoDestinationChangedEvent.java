package com.gusrylmubarok.cargotracker.bookingms.domain.events;

import com.gusrylmubarok.cargotracker.bookingms.domain.model.RouteSpecification;

public class CargoDestinationChangedEvent {
    private String bookingId;
    private RouteSpecification routeSpecification;

    public RouteSpecification getNewRouteSpecification(){ return this.routeSpecification;}

    public CargoDestinationChangedEvent(String bookingId, RouteSpecification routeSpecification) {
        this.bookingId = bookingId;
        this.routeSpecification = routeSpecification;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public RouteSpecification getRouteSpecification() {
        return routeSpecification;
    }

    public void setRouteSpecification(RouteSpecification routeSpecification) {
        this.routeSpecification = routeSpecification;
    }
}
