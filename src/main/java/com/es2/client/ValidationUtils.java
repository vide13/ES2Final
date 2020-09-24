package com.es2.client;

import com.es2.exceptions.*;

public class ValidationUtils {
    public static void isValidNameArgument(String arg) throws InvalidNameException {
        if (arg == null) throw new InvalidNameException("Argument can't be null");
        else if (arg.length() > 50) throw new InvalidNameException("Argument can't exceed 50 characters");
        else if (arg.length() < 2) throw new InvalidNameException("Argument must contain more than 2 characters");
        else if (arg.isBlank()) throw new InvalidNameException("Argument must contain other characters");
    }

    public static void isValidJobArgument(String arg) throws InvalidJobException {
        if (arg == null) throw new InvalidJobException("Argument can't be null");
        else if (arg.length() > 50) throw new InvalidJobException("Argument can't exceed 50 characters");
        else if (arg.length() < 2) throw new InvalidJobException("Argument must contain more than 2 characters");
        else if (arg.isBlank()) throw new InvalidJobException("Argument must contain other characters");
    }

    public static void isValidEmailArgument(String arg) throws InvalidEmailException {
        if (arg == null) throw new InvalidEmailException("Email can't be null");
        else if (arg.length() > 128) throw new InvalidEmailException("Email can't exceed 128 characters");
        else if (arg.length() < 3) throw new InvalidEmailException("Email must contain more than 2 characters");
        else if (arg.isBlank()) throw new InvalidEmailException("Email must contain other characters");
    }

    public static void isValidPasswordArgument(String arg) throws InvalidPasswordException {
        if (arg == null) throw new InvalidPasswordException("Password can't be null");
        else if (arg.length() > 128) throw new InvalidPasswordException("Password can't exceed 128 characters");
        else if (arg.length() < 8) throw new InvalidPasswordException("Password must contain more than 7 characters");
        else if (arg.isBlank()) throw new InvalidPasswordException("Password must contain other characters");
    }

    public static void isValidIntegerArgument(Integer arg) throws InvalidIdException {
        if (arg == null) throw new InvalidIdException("Id can't be null");
        else if (arg > 10000) throw new InvalidIdException("Id can't exceed number 10000");
        else if (arg < 1) throw new InvalidIdException("Id must be bigger than 0");
    }

    public static void isValidToken(String arg) throws InvalidTokenException {
        if (arg == null) throw new InvalidTokenException("Invalid Token");
    }
}