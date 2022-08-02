package com.gusrylmubarok.cargotracker.bookingms.domain.commands;

import com.gusrylmubarok.cargotracker.bookingms.domain.model.Leg;

import java.util.List;

/*
** Implementation class for the assign route to cargo command
 */
public class AssignRouteToCargoCommand {
    /*
    ** Identifier to indicate to axon framework the unique instance
    ** on which the command needs to be processed
     */
    private String bookedId;
    private List<Leg> legs;

    public AssignRouteToCargoCommand(String bookedId, List<Leg> legs) {
        this.bookedId = bookedId;
        this.legs = legs;
    }

    public String getBookedId() {
        return bookedId;
    }

    public void setBookedId(String bookedId) {
        this.bookedId = bookedId;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }
}
