package com.gusrylmubarok.cargotracker.bookingms.domain.model;

import com.gusrylmubarok.cargotracker.bookingms.domain.commands.BookCargoCommand;

import java.util.Date;

/*
** Route specification of the cargo - origin
** Destination and arrival deadline
 */
public class RouteSpecification extends Cargo {
    private Location origin;
    private Location destination;
    private Date arrivalDeadline;

    public RouteSpecification(Location origin, Location destination,
                              Date arrivalDeadline) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalDeadline = arrivalDeadline;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Date getArrivalDeadline() {
        return arrivalDeadline;
    }

    public void setArrivalDeadline(Date arrivalDeadline) {
        this.arrivalDeadline = arrivalDeadline;
    }
}
