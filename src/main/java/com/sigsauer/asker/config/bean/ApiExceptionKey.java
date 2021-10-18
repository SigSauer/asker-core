package com.sigsauer.asker.config.bean;

import com.sigsauer.asker.biz.exceptions.shared.EntityConflictException;
import com.sigsauer.asker.biz.exceptions.shared.EntityNotFoundException;
import com.sigsauer.asker.extapi.exceptions.ApiException;
import com.sigsauer.asker.extapi.exceptions.ResourceNotFoundException;

import javax.ws.rs.core.Response.Status;
import java.util.Arrays;

public enum ApiExceptionKey {

    API(ApiException.class) {
        @Override
        public Status getStatus() {
            return Status.INTERNAL_SERVER_ERROR;
        }

        @Override
        public String getDescription(String message) {
            return "API EXCEPTION. API is temporarily unavailable. Details: "+ message;
        }
    },
    RESOURCE_NOT_FOUND(ResourceNotFoundException.class) {
        @Override
        public Status getStatus() {
            return Status.BAD_REQUEST;
        }

        @Override
        public String getDescription(String message) {
            return "RESOURCE EXCEPTION. Resource does not exist. Details: "+ message;
        }
    },
    ENTITY_CONFLICT(EntityConflictException.class) {
        @Override
        public Status getStatus() {
            return Status.CONFLICT;
        }

        @Override
        public String getDescription(String message) {
            return "UNABLE to save/update entity. Duplicate values detected. Details: " + message;
        }
    },
    ENTITY_NOT_FOUND(EntityNotFoundException.class) {
        @Override
        public Status getStatus() {
            return Status.NOT_FOUND;
        }

        @Override
        public String getDescription(String message) {
            return "Entity does not exist. Details: " + message;
        }
    },

    ;

    private Class<? extends Exception> exception;

    ApiExceptionKey(Class<? extends Exception> e) {
        this.exception = e;
    }

    public static ApiExceptionKey getApiException(Class<? extends Exception> exception) {
        return Arrays.stream(ApiExceptionKey.values()).filter(ex -> ex.exception == exception).findFirst().orElse(API);
    }

    public Class<? extends Exception> getException() {
        return exception;
    }

    public void setException(Class<? extends Exception> exception) {
        this.exception = exception;
    }

    public abstract Status getStatus();

    public abstract String getDescription(String message);
}
