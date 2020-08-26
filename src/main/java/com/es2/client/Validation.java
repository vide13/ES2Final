package com.es2.client;

public class Validation {
    public static boolean isValidStringArgument(String arg) {
        if (arg == null) return false;
        else if (arg.length() > 50) return false;
        else if (arg.isEmpty()) return false;
        else return !arg.isBlank();
    }

    public static boolean isValidPasswordArgument(String arg) {
        if (arg == null) return false;
        else if (arg.length() > 128) return false;
        else if (arg.length() < 8) return false;
        else return !arg.isBlank();
    }

    public static boolean isValidIntegerArgument(Integer arg) {
        if (arg == null) return false;
        else if (arg > 10000) return false;
        else return arg >= 1;
    }

    public static boolean isValidToken(String arg) {
        return arg != null;
    }
}