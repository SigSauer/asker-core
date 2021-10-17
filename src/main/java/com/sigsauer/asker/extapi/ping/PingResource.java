package com.sigsauer.asker.extapi.ping;

import com.sigsauer.asker.biz.services.UserService;
import com.sigsauer.asker.biz.services.UserServiceImpl;
import com.sigsauer.asker.biz.user.bean.UserDO;
import com.sigsauer.asker.extapi.shared.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class PingResource {

    UserService userService = new UserServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse pingGet() {
        return ApiResponse.found("Welcome to Asker API Application!");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse pingPost() {
        return ApiResponse.accepted("Welcome to Asker API Application!");
    }

    @GET()
    @Path("/help")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse help() {
        UserDO user = new UserDO("username", "email", "password", true, "photo", "locale");
        userService.save(user);
        UserDO received = userService.findByUsername("username");
        return ApiResponse.ok("user", received);
    }

}
