package com.sanitas.calculator.exception;

import com.sanitas.calculator.exception.ErrorResponse;
import com.sanitas.calculator.exception.NullOperandException;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final TracerImpl tracer = new TracerImpl();

    @ExceptionHandler(NullOperandException.class)
    public ResponseEntity<ErrorResponse> handleNullOperand(NullOperandException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        tracer.trace(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOperationException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_IMPLEMENTED, e.getMessage());
        tracer.trace(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_IMPLEMENTED);
    }
}
