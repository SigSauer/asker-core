package com.sigsauer.asker.utils;

public class StringUtils {

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static String concat(String... values) {
        StringBuilder result = new StringBuilder();
        for (String v: values) {
            result.append(v);
        }
        return result.toString();
    }
}
