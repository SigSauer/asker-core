package com.sigsauer.asker.extapi.user;

import com.sigsauer.asker.api.user.UserAPI;
import com.sigsauer.asker.api.user.bean.UserAO;
import com.sigsauer.asker.extapi.shared.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);

    private UserAPI userAPI;

    @Inject
    public UserResource(UserAPI userAPI) {
        this.userAPI = userAPI;
    }

    @GET
    public ApiResponse getAllUsers() {
        List<UserAO> users = userAPI.getAllUsers();
        log.info(users.toString());
        log.debug(users.toString());
        log.warn(users.toString());
        log.error(users.toString());
        return ApiResponse.ok("users", users);
    }

    @GET
    @Path("/{id}")
    public ApiResponse getOneUser(@PathParam(value = "id") String id) {
        UserAO user = userAPI.getById(id);
        return ApiResponse.ok("user", user);
    }

    @POST
    public ApiResponse createUser(UserAO user) {
        UserAO saved = userAPI.createUser(user);
        log.info(saved.toString());
        return ApiResponse.ok("user", saved);
    }

    @PUT
    @Path("/{id}")
    public ApiResponse updateUser(@PathParam(value = "id") String id, UserAO user) {
        UserAO updated = userAPI.updateUser(id, user);
        log.info(updated.toString());
        return ApiResponse.ok("user", updated);
    }

    @DELETE
    @Path("/{id}")
    public ApiResponse deleteUser(@PathParam(value = "id") String id) {
        userAPI.deleteUser(id);
        return ApiResponse.ok(String.format("User with ID=%s deleted successful", id));
    }



}
