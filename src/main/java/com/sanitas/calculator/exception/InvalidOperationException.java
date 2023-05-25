package com.sanitas.calculator.exception;

public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException(String message) {
        super(message);
    }
}
