package com.gusrylmubarok.booking.interfaces.rest;

import com.gusrylmubarok.booking.application.internal.commandservices.CargoBookingCommandService;
import com.gusrylmubarok.booking.interfaces.rest.dto.RouteCargoResource;
import com.gusrylmubarok.booking.interfaces.rest.transform.RouteCargoCommandDTOAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cargorouting")
@ApplicationScoped
public class CargoRoutingController {

    @Inject
    private CargoBookingCommandService cargoBookingCommandService; // Application Service Dependency


    /**
     * POST method to route a cargo
     * @param routeCargoResource
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response routeCargo(RouteCargoResource routeCargoResource){
        cargoBookingCommandService.assignRouteToCargo(
                RouteCargoCommandDTOAssembler.toCommandFromDTO(routeCargoResource));

        final Response returnValue = Response.ok()
                .entity("Cargo Routed")
                .build();
        return returnValue;
    }


}
