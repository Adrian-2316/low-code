package com.project.lowcode.shared;

public class StringUtils {

    public static String toLowerCamelCase(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    public static String toUpperCamelCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
