package com.sanitas.calculator.exception;

public class NullOperandException extends RuntimeException{

    public NullOperandException(String message) {
        super(message);
    }
}
