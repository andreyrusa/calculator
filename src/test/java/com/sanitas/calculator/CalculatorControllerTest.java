package com.sanitas.calculator;

import com.sanitas.calculator.controller.CalculatorController;
import com.sanitas.calculator.model.OperationRequest;
import com.sanitas.calculator.model.OperationResponse;
import com.sanitas.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorControllerTest {

    CalculatorService calculatorService;
    TracerImpl tracer;
    CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        calculatorService = mock(CalculatorService.class);
        tracer = mock(TracerImpl.class);
        calculatorController = new CalculatorController(calculatorService, tracer);
    }

    @Test
    void testCalculateSum() {
        when(calculatorService.calculate("sum", new BigDecimal("3"), new BigDecimal("2")))
                .thenReturn(new BigDecimal("5"));

        ResponseEntity<OperationResponse> response = calculatorController.calculate("sum", new OperationRequest(new BigDecimal("3"), new BigDecimal("2")));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("5"), Objects.requireNonNull(response.getBody()).getResult());

        verify(calculatorService, times(1)).calculate("sum", new BigDecimal("3"), new BigDecimal("2"));
        verify(tracer, times(2)).trace(anyString());
    }

    @Test
    void testCalculateSubstract() {
        when(calculatorService.calculate("subtract", new BigDecimal("3"), new BigDecimal("2")))
                .thenReturn(new BigDecimal("1"));

        ResponseEntity<OperationResponse> response = calculatorController.calculate("subtract", new OperationRequest(new BigDecimal("3"), new BigDecimal("2")));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("1"), Objects.requireNonNull(response.getBody()).getResult());

        verify(calculatorService, times(1)).calculate("subtract", new BigDecimal("3"), new BigDecimal("2"));
        verify(tracer, times(2)).trace(anyString());
    }

}
