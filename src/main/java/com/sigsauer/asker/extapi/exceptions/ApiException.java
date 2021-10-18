package com.sigsauer.asker.extapi.exceptions;

import com.sigsauer.asker.utils.StringUtils;

public class ApiException extends RuntimeException {

    public ApiException() {
        super("API Internal Error");
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String... messages) {
        super(StringUtils.concat(messages));
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
