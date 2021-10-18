package com.sigsauer.asker.config.providers;

import com.sigsauer.asker.config.bean.ApiExceptionKey;
import com.sigsauer.asker.extapi.shared.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class ApiExceptionProvider implements ExceptionMapper<Exception> {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionProvider.class);

    @Override
    public Response toResponse(Exception exception) {
        UUID id = UUID.randomUUID();
        ApiExceptionKey key = ApiExceptionKey.getApiException(exception.getClass());
        String exceptionMessage = String.format("UUID (%s) - %s", id, key.getDescription(exception.getMessage()));
        log.error(exceptionMessage, exception);
        ApiResponse apiResponse = new ApiResponse(key.getStatus());
        apiResponse.addMessage(exceptionMessage);

        return apiResponse.toResponse();
    }
}
