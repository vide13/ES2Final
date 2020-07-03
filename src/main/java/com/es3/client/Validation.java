package com.es3.client;

public class Validation {
    public static boolean isValidStringArgument(String arg) {
        if (arg == null) return false;
        else if (arg.length() > 50) return false;
        else if (arg.isEmpty()) return false;
        else return !arg.isBlank();
    }

    public static boolean isValidIntegerArgument(Integer arg) {
        if (arg == null) return false;
        else if (arg > 9999) return false;
        else return arg >= 1;
    }
}
