package com.gusrylmubarok.cargotracker.bookingms.domain.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

public class BookCargoCommand {
    /*
    ** Identifier to indicate to Axon Framework the unique instance
    ** on which the command needs to be processed
     */
    @TargetAggregateIdentifier
    private String bookingId;
    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    private Date destArrivalDeadline;

    public BookCargoCommand(String bookingId, int bookingAmount, String originLocation,
                            String destLocation, Date destArrivalDeadline) {
        this.bookingId = bookingId;
        this.bookingAmount = bookingAmount;
        this.originLocation = originLocation;
        this.destLocation = destLocation;
        this.destArrivalDeadline = destArrivalDeadline;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestLocation() {
        return destLocation;
    }

    public void setDestLocation(String destLocation) {
        this.destLocation = destLocation;
    }

    public Date getDestArrivalDeadline() {
        return destArrivalDeadline;
    }

    public void setDestArrivalDeadline(Date destArrivalDeadline) {
        this.destArrivalDeadline = destArrivalDeadline;
    }
}
