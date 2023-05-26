package com.sanitas.calculator;

import com.sanitas.calculator.model.OperationRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationRequestTest {

    @Test
    public void testGetSetOperand1() {
        BigDecimal value = new BigDecimal("3.0");
        OperationRequest request = new OperationRequest();
        request.setOperand1(value);
        assertEquals(value, request.getOperand1());
    }

    @Test
    public void testGetSetOperand2() {
        BigDecimal value = new BigDecimal("2.0");
        OperationRequest request = new OperationRequest();
        request.setOperand2(value);
        assertEquals(value, request.getOperand2());
    }

    @Test
    public void testToString() {
        BigDecimal value1 = new BigDecimal("3.0");
        BigDecimal value2 = new BigDecimal("2.0");
        OperationRequest request = new OperationRequest(value1, value2);
        String expectedString = "OperationRequest{operand1=" + value1 + ", operand2=" + value2 + "}";
        assertEquals(expectedString, request.toString());
    }
}
