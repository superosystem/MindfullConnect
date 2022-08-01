package com.gusrylmubarok.tracking.interfaces.events;

import com.gusrylmubarok.shareddomain.events.CargoBookedEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class CargoBookedEventHandler {

    public void testEventObserving(@Observes CargoBookedEvent event) {
        // Processing of an event
        System.out.println("***Just a Test***"+event.getId());
    }
}
