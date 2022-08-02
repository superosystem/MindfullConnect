package com.gusrylmubarok.cargotracker.bookingms.domain.model;

import com.gusrylmubarok.cargotracker.bookingms.domain.commands.AssignRouteToCargoCommand;
import com.gusrylmubarok.cargotracker.bookingms.domain.commands.BookCargoCommand;
import com.gusrylmubarok.cargotracker.bookingms.domain.commands.ChangeDestinationCommand;
import com.gusrylmubarok.cargotracker.bookingms.domain.events.CargoBookedEvent;
import com.gusrylmubarok.cargotracker.bookingms.domain.events.CargoDestinationChangedEvent;
import com.gusrylmubarok.cargotracker.bookingms.domain.events.CargoRoutedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;;

@Aggregate
public class Cargo {
    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Aggregat identifier
    @AggregateIdentifier
    private String bookingId;
    // Booking amount
    private BookingAmount bookingAmount;
    // Origin location of the cargo
    private Location origin;
    // Route specification of the cargo
    private RouteSpecification routeSpecification;
    // Itinerary assigned to the cargo
    private Itinerary itinerary;
    // Routing status of the cargo
    private RoutingStatus routingStatus;
    // Transport status of the cargo
    private TransportStatus transportStatus;

    protected Cargo() {
        logger.info("Empty Cargo created!");
    }

    @CommandHandler
    public Cargo(BookCargoCommand bookCargoCommand) {
        logger.info("Hanling {}", bookCargoCommand);
        if(bookCargoCommand.getBookingAmount() < 0) {
            throw new IllegalArgumentException("Booking amount cannot be negative.");
        }

        apply(new CargoBookedEvent(bookCargoCommand.getBookingId(),
                new BookingAmount(bookCargoCommand.getBookingAmount()),
                new Location(bookCargoCommand.getOriginLocation()),
                new RouteSpecification(
                        new Location(bookCargoCommand.getOriginLocation()),
                        new Location(bookCargoCommand.getDestLocation()),
                        bookCargoCommand.getDestArrivalDeadline())));
    }

    /*
    ** Command handler for assigning the route to a cargo
    */
    @CommandHandler
    public void handleAssigntoRoute(AssignRouteToCargoCommand assignRouteToCargoCommand) {
        logger.info("Booking Id" + assignRouteToCargoCommand.getBookedId());
        logger.info("Assign Route to Command"+ routingStatus);
        logger.info("Assign Route to Command"+ this.routingStatus);
        if(routingStatus.equals(RoutingStatus.ROUTED)) {
            throw new IllegalArgumentException("Cargo already routed.");
        }
        apply(new CargoRoutedEvent(assignRouteToCargoCommand.getBookedId(),
                new Itinerary(assignRouteToCargoCommand.getLegs())));
    }

    /*
    * Cargo hamdler for changing the destination of cargo
    */
    public void handleChangeDestination(ChangeDestinationCommand changeDestinationCommand) {
        if(routingStatus.equals(RoutingStatus.ROUTED)){
            throw new IllegalArgumentException("Cannot change destination of a Routed Cargo");
        }

        apply(new CargoDestinationChangedEvent(changeDestinationCommand.getBookingId(),
                new RouteSpecification(origin, new Location(changeDestinationCommand.getNewDestinationLocation()),
                        routeSpecification.getArrivalDeadline())));
    }

    /*
    ** Event Handler for the Cargo Booked Event
    ** Annotation indicating that the Aggregate is Event Sourced and is interested in the Cargo Booked Event raised by the Book Cargo Command
     */
    @EventSourcingHandler
    public void on(CargoBookedEvent cargoBookedEvent) {
        logger.info("Applying {}", cargoBookedEvent);
        // State being maintained
        bookingId = cargoBookedEvent.getBookingId();
        bookingAmount = cargoBookedEvent.getBookingAmount();
        origin = cargoBookedEvent.getOriginLocation();
        routeSpecification = cargoBookedEvent.getRouteSpecification();
        routingStatus = RoutingStatus.NOT_ROUTED;
        transportStatus = TransportStatus.NOT_RECEIVED;
        logger.info("Routing Status is"+routingStatus);
    }

    /*
    ** Event Handler for the Cargo Routed Event
    ** Annotation indicating that the Aggregate is Event Sourced and is interested in the Cargo Routed Event raised by the Book Cargo Command
    */
    @EventSourcingHandler //
    public void on(CargoRoutedEvent cargoRoutedEvent) {
        logger.info("Applying {}", cargoRoutedEvent);
        itinerary = cargoRoutedEvent.getItinerary();
        routingStatus = RoutingStatus.ROUTED;
    }

    /*
    ** Event Handler for the Change Destination Event
    ** Annotation indicating that the Aggregate is Event Sourced and is interested in the Cargo Booked Event raised by the Book Cargo Command
    */
    @EventSourcingHandler
    public void on(CargoDestinationChangedEvent cargoDestinationChangedEvent) {
        logger.info("Applying {}", cargoDestinationChangedEvent);
        routingStatus = RoutingStatus.NOT_ROUTED;
        routeSpecification = cargoDestinationChangedEvent.getNewRouteSpecification();

    }

}
