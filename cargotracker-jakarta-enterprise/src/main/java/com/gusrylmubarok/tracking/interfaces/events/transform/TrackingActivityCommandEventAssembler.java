package com.gusrylmubarok.tracking.interfaces.events.transform;

import com.gusrylmubarok.shareddomain.events.CargoHandledEvent;
import com.gusrylmubarok.shareddomain.events.CargoHandledEventData;
import com.gusrylmubarok.tracking.domain.model.commands.AddTrackingEventCommand;

/**
 * Assembler class to convert the Cargo Routed Event to the Assign Tracking Number Command Model
 */
public class TrackingActivityCommandEventAssembler {

    /**
     * Static method within the Assembler class
     * @param cargoHandledEvent
     * @return AssignTrackingNumberCommand Model
     */
    public static AddTrackingEventCommand toCommandFromEvent(CargoHandledEvent cargoHandledEvent){
        CargoHandledEventData eventData = cargoHandledEvent.getContent();
        return new AddTrackingEventCommand(
                eventData.getBookingId(),
                eventData.getHandlingCompletionTime(),
                eventData.getHandlingType(),
                eventData.getHandlingLocation(),
                eventData.getVoyageNumber());
    }
}
