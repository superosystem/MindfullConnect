package com.gusrylmubarok.shareddomain.events;


/**
 * Event Class for the Cargo Routed Event. Wraps up the Cargo
 */

public class CargoRoutedEvent {
    private CargoRoutedEventData cargoRoutedEventData;
    public CargoRoutedEvent(){}
    public void setContent(CargoRoutedEventData cargoRoutedEventData) { this.cargoRoutedEventData = cargoRoutedEventData; }
    public CargoRoutedEventData getContent() {
        return cargoRoutedEventData;
    }
}