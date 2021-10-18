package com.sigsauer.asker.config.bean;

public enum ApiMessage {

    UNABLE_TO_UPDATE_USER("Unable to UPDATE User with ID = %s", 1),
    EMAIL_OR_USERNAME_ALREADY_USED("EMAIL or USERNAME already exist", 0),
    USER_ALREADY_EXIST("", 0),

    ;

    private final String message;
    private final int args;

    ApiMessage(String message, int args) {
        this.message = message;
        this.args = args;
    }
    public String getMessage() {
        return message;
    }

    public String message(Object... objects) {
        if (args == 0) return this.message+". ";
        String[] arguments = new String[this.args];
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = objects[i].toString();
        }
        return String.format(this.message+". ", arguments);
    }

    public static String message(ApiMessage message, Object... objects) {
        return message.message(objects);
    }
}
