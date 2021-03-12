package org.acme.quickstart;

import org.acme.quickstart.domain.Developer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.logging.Logger;

@Path("/developer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeveloperResource {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GreetingResource.class));

    @POST
    public Response createDeveloper(Developer developer) {

        if (developer == null) {
            return Response.serverError().build();
        }

        developer.persist();

        LOGGER.info("developer" + developer.toString());
        return Response.created(
                UriBuilder
                        .fromResource(DeveloperResource.class)
                        .path(Long.toString(developer.getId()))
                        .build()
        )
                .entity(developer)
                .build();

    }
}
