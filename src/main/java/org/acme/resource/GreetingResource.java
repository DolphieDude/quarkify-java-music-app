package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Greeting;
import org.acme.service.GreetingService;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestQuery String input) {
        Greeting greeting = new Greeting();
        greeting.setName(input);
        greeting.persist(); //Well it's a GET method, but I am testing persistence

        return "Your message is " + input;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(String name) {
        return service.greeting(name);
    }

}
