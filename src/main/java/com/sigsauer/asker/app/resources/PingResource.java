package com.sigsauer.asker.app.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ping")
public class PingResource {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Hello honey <3";
    }
}
