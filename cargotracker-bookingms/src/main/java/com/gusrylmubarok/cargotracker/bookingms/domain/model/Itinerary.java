package com.gusrylmubarok.cargotracker.bookingms.domain.model;

import java.util.Collections;
import java.util.List;

public class Itinerary extends Cargo {
    private List<Leg> legs = Collections.emptyList();

    public Itinerary() {
    }

    public Itinerary(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Leg> getLegs() {
        return legs;
    }
}
