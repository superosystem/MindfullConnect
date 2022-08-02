package com.gusrylmubarok.cargotracker.bookingms.domain.events;

import com.gusrylmubarok.cargotracker.bookingms.domain.model.BookingAmount;
import com.gusrylmubarok.cargotracker.bookingms.domain.model.Location;
import com.gusrylmubarok.cargotracker.bookingms.domain.model.RouteSpecification;

/*
** Event resulting from cargo booking command
 */
public class CargoBookedEvent {
    private String bookingId;
    private BookingAmount bookingAmount;
    private Location originLocation;
    private RouteSpecification routeSpecification;

    public CargoBookedEvent(String bookingId, BookingAmount bookingAmount,
                            Location originLocation, RouteSpecification routeSpecification) {
        this.bookingId = bookingId;
        this.bookingAmount = bookingAmount;
        this.originLocation = originLocation;
        this.routeSpecification = routeSpecification;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public BookingAmount getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BookingAmount bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(Location originLocation) {
        this.originLocation = originLocation;
    }

    public RouteSpecification getRouteSpecification() {
        return routeSpecification;
    }

    public void setRouteSpecification(RouteSpecification routeSpecification) {
        this.routeSpecification = routeSpecification;
    }
}
