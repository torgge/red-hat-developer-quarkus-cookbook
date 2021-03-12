package org.acme.quickstart;

import org.acme.quickstart.enums.Order;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GreetingResource.class));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @NotBlank @HeaderParam("authorization") String authorization
    ) {
        return String.format("URI: %s - Order %s - Authorization: %s",
                              uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String message) {
        LOGGER.info("CREATE");
        LOGGER.info(message);
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        LOGGER.info("UPDATE");
        return message;
    }

    @DELETE
    public void delete() {
        LOGGER.info("DELETE");
    }


}