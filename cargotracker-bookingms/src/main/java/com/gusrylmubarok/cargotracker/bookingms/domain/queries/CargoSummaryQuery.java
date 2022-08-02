package com.gusrylmubarok.cargotracker.bookingms.domain.queries;

/*
** Implementation of cargo summary query class.
 */
public class CargoSummaryQuery {
    private String bookingId; //Criteria of the Query
    public CargoSummaryQuery(String bookingId){
        this.bookingId = bookingId;
    }

    public String getBookingId(){return this.bookingId;}
    @Override
    public String toString() { return "Cargo Summary for Booking Id" + bookingId; }
}
