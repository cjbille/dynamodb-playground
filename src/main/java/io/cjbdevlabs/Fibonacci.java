package io.cjbdevlabs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fibonacci/{number}")
public class Fibonacci {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getFibonnaciNumber(@PathParam("number") int n) {
        return String.valueOf(fibonacci(n));
    }

    private int fibonacci(int pos) {
        if (pos <= 1) {
            return pos;
        }
        return fibonacci(pos - 1) + fibonacci(pos - 2);
    }
}
