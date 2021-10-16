package com.sigsauer.asker.api.resources;

import com.sigsauer.asker.api.resources.shared.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class PingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse ping() {
        return ApiResponse.found("Welcome to Asker API Application!");
    }

}
