package com.sigsauer.asker.api.resources.shared;

import javax.ws.rs.core.Response.Status;
import java.util.HashMap;

public class ApiResponse {

    private Status status;

    private String message;

    private HashMap<String, Object> results = new HashMap<>();


    public ApiResponse(Status status) {
        this.status = status;
    }

    public void addResult(String name, Object result) {
        this.results.put(name, result);
    }


    private void setMessage(String message) {
        this.message = message;
    }

    //200
    public static ApiResponse ok(String message) {
        return build(Status.OK, message);
    }

    //200
    public static ApiResponse ok(String name, Object result) {
        return build(Status.OK, name, result);
    }

    //201
    public static ApiResponse created(String message) {
        return build(Status.CREATED, message);
    }

    //202
    public static ApiResponse accepted(String name, Object result) {
        return build(Status.ACCEPTED, name, result);
    }

    //303
    public static ApiResponse found(String message) {
        return build(Status.FOUND, message);
    }

    //400
    public static ApiResponse error(String message) {
        return build(Status.BAD_REQUEST, message);
    }

    //401
    public static ApiResponse unauthorized(String message) {
        return build(Status.UNAUTHORIZED, message);
    }

    //403
    public static ApiResponse forbidden(String message) {
        return build(Status.FORBIDDEN, message);
    }

    //404
    public static ApiResponse notFound(String message) {
        return build(Status.NOT_FOUND, message);
    }

    //405
    public static ApiResponse notAllowed(String message) {
        return build(Status.METHOD_NOT_ALLOWED, message);
    }

    //500
    public static ApiResponse serverError(String message) {
        return build(Status.INTERNAL_SERVER_ERROR, message);
    }

    //501
    public static ApiResponse notImplemented(String message) {
        return build(Status.NOT_IMPLEMENTED, message);
    }

    private static ApiResponse build(Status status, String message) {
        ApiResponse response = new ApiResponse(status);
        response.setMessage(message);
        return response;
    }

    private static ApiResponse build(Status status, String name, Object result) {
        ApiResponse response = new ApiResponse(status);
        response.addResult(name, result);
        return response;
    }

}
