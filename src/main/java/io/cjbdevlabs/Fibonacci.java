package io.cjbdevlabs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Path("/fibonacci/{number}")
public class Fibonacci {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getFibonnaciNumber(@PathParam("number") int n) {
        try {
            return storeSequence(n);
        } catch (IOException e) {
            log.infof("Error in request: %s", e.getMessage());
            return "Error occurred";
        }
    }

    private String storeSequence(int sequence) throws IOException {
        String name = "fib.txt";
        var file = new File(name);
        file.createNewFile();
        var fileWriter = new FileWriter(file);
        fileWriter.write(sequence);
        fileWriter.flush();
        fileWriter.close();
        return name;
    }
}
