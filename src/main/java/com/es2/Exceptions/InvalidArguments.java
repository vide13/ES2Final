package com.es2.exceptions;

public class InvalidArguments extends Throwable {
    @Override
    public String getMessage() {
        return "Invalid Arguments";
    }
}
