package com.gusrylmubarok.cargotracker.bookingms.domain.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ChangeDestinationCommand {
    // identifier to indicate to axon framework the unique instance on which the command needs to be processed
    @TargetAggregateIdentifier
    private String bookingId;
    private String newDestinationLocation;

    public ChangeDestinationCommand(String bookingId, String newDestinationLocation) {
        this.bookingId = bookingId;
        this.newDestinationLocation = newDestinationLocation;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getNewDestinationLocation() {
        return newDestinationLocation;
    }

    public void setNewDestinationLocation(String newDestinationLocation) {
        this.newDestinationLocation = newDestinationLocation;
    }
}
