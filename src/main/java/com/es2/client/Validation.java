package com.es2.client;

import com.es2.exceptions.InvalidPasswordException;

public class Validation {
    public static boolean isValidStringArgument(String arg) {
        if (arg == null) return false;
        else if (arg.length() > 50) return false;
        else if (arg.isEmpty()) return false;
        else return !arg.isBlank();
    }

    public static void isValidPasswordArgument(String arg) throws InvalidPasswordException {
        if (arg == null) throw new InvalidPasswordException("Password can't be null");
        else if (arg.length() > 128) throw new InvalidPasswordException("Password can't exceed 128 characters");
        else if (arg.length() < 8) throw new InvalidPasswordException("Password must contain more then 7 characters");
        else if (arg.isBlank()) throw new InvalidPasswordException("Password must contain other characters");
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