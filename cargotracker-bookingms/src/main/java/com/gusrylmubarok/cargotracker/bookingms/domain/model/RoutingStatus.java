package com.gusrylmubarok.cargotracker.bookingms.domain.model;

public enum RoutingStatus {
    NOT_ROUTED,
    ROUTED,
    MISROUTED;

    public boolean sameValuesAs(RoutingStatus other) {
        return this.equals(other);
    }

}
