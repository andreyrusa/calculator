package com.sanitas.calculator.controller;

import com.sanitas.calculator.exception.ErrorResponse;
import com.sanitas.calculator.exception.NullOperandException;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    private final TracerImpl tracer = new TracerImpl();

    @ExceptionHandler(NullOperandException.class)
    public ResponseEntity<ErrorResponse> handleNullOperand(NullOperandException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        tracer.trace(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Se produjo un error interno del servidor");
        tracer.trace(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
