package com.es2.Exceptions;

public class InvalidArguments extends Throwable {
    @Override
    public String getMessage() {
        return "Invalid Arguments";
    }
}
