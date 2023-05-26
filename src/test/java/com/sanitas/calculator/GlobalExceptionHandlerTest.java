package com.sanitas.calculator;

import com.sanitas.calculator.exception.ErrorResponse;
import com.sanitas.calculator.exception.GlobalExceptionHandler;
import com.sanitas.calculator.exception.InvalidOperationException;
import com.sanitas.calculator.exception.NullOperandException;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTest {

    private TracerImpl tracer;
    private GlobalExceptionHandler handler;

    @BeforeEach
    public void setUp() {
        tracer = Mockito.mock(TracerImpl.class);
        handler = new GlobalExceptionHandler(tracer);
        Mockito.doNothing().when(tracer).trace(Mockito.anyString());
    }

    @Test
    public void handleNullOperand() {
        NullOperandException exception = new NullOperandException("Null operand error");

        ResponseEntity<ErrorResponse> responseEntity = handler.handleNullOperand(exception);

        verify(tracer).trace(Mockito.anyString());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Null operand error", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleInvalidOperationException() {
        InvalidOperationException exception = new InvalidOperationException("Invalid operation error");

        ResponseEntity<ErrorResponse> responseEntity = handler.handleInvalidOperationException(exception);

        verify(tracer).trace(Mockito.anyString());
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
        assertEquals("Invalid operation error", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleNumberFormatException() {
        NumberFormatException exception = new NumberFormatException("Number format error");

        ResponseEntity<ErrorResponse> responseEntity = handler.handleNumberFormatException(exception);

        verify(tracer).trace(Mockito.anyString());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Invalid operand: Number format error", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleGenericException() {
        Exception exception = new Exception("Generic error");

        ResponseEntity<ErrorResponse> responseEntity = handler.handleGenericException(exception);

        verify(tracer).trace(Mockito.anyString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("An error occurred: Generic error", responseEntity.getBody().getMessage());
    }
}