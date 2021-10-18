package com.sigsauer.asker.extapi.ping;

import com.sigsauer.asker.extapi.shared.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class PingResource {

    private static final Logger log = LoggerFactory.getLogger(PingResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse pingGet() {
        log.info("Ping GET Request is successful");
        return ApiResponse.found("Welcome to Asker API Application!");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse pingPost() {
        log.info("Ping POST Request is successful");
        return ApiResponse.accepted("Welcome to Asker API Application!");
    }

}
