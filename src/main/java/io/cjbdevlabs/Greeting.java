package io.cjbdevlabs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class Greeting {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("name")
    @Produces(MediaType.TEXT_PLAIN)
    public String name(@QueryParam("name") String name) {
        return String.format("Hello there %s", name);
    }
}
