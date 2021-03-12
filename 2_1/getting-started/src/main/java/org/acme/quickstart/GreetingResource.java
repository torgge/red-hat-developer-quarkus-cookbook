package org.acme.quickstart;

import org.acme.quickstart.domain.Teste;
import org.acme.quickstart.enums.Order;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GreetingResource.class));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @NotBlank @HeaderParam("authorization") String authorization
    ) {
        return String.format("URI: %s - Order %s - Authorization: %s",
                uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String message) {
        LOGGER.info("CREATE");
        LOGGER.info(message);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(String message) {
        LOGGER.info("UPDATE");
        return message;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete() {
        LOGGER.info("DELETE");
    }

    @GET
    @Path("text-response")
    @Produces(MediaType.TEXT_PLAIN)
    public Response textResponse() {
        Teste teste = new Teste();
        return Response
                .ok()
                .entity(teste.getTexto())
                .build();
    }

    @GET
    @Path("obj-response")
    @Produces(MediaType.APPLICATION_JSON)
    public Response objResponse() {
        return Response
                .ok()
                .entity(new Teste())
                .build();
    }


}