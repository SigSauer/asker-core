package com.sigsauer.asker.api.resources.shared.utils;

import com.sigsauer.asker.api.resources.shared.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class ApiResponseProvider implements MessageBodyWriter<ApiResponse>  {

    private static final Logger log = LoggerFactory.getLogger(ApiResponseProvider.class);

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return type == ApiResponse.class;
    }

    @Override
    public void writeTo(ApiResponse response, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException {
        log.debug(response.toString());
        switch (mediaType.toString()) {
            case MediaType.APPLICATION_JSON:
                writeToJSON(outputStream, response);
                break;
            case MediaType.TEXT_PLAIN:
            default:
                writeToText(outputStream, response);
                break;
        }
    }



    private void writeToJSON(OutputStream outputStream, ApiResponse response) throws IOException {
        ResponseWrapper wrapper = new ResponseWrapper(response);
        outputStream.write(wrapper.json().getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private void writeToText(OutputStream outputStream, ApiResponse response) throws IOException {
        ResponseWrapper wrapper = new ResponseWrapper(response);
        outputStream.write(wrapper.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
