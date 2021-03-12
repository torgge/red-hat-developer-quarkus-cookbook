package org.acme.quickstart;

import io.quarkus.vertx.http.runtime.filters.Filters;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    public void routes(@Observes Router router) {
        router
                .get("/ok")
                .handler(rc -> rc.response().end("OK from Route"));
    }

    @Route(path = "/declarativeok", methods = HttpMethod.GET)
    public void greetings(RoutingContext routingContext) {
        String name = routingContext.request().getParam("name");
        if (name == null) {
            name = "world";
        }
        routingContext.response().end("OK " + name + " you are right");
    }

    public void filters(@Observes Filters filters) {
        filters
                .register(rc -> {
                    rc.response()
                            .putHeader("V-Header", "Header added by VertX Filter");
                    rc.next();
                }, 10);
    }


}
