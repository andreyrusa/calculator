package com.sanitas.calculator;

import com.sanitas.calculator.model.OperationResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationResponseTest {

    @Test
    public void testGetSetResult() {
        BigDecimal value = new BigDecimal("7.0");
        OperationResponse response = new OperationResponse("sum", new BigDecimal("3.0"), new BigDecimal("4.0"), value);
        assertEquals(value, response.getResult());
    }

    @Test
    public void testGetSetOperation() {
        String operation = "subtract";
        OperationResponse response = new OperationResponse(operation, new BigDecimal("5.0"), new BigDecimal("2.0"), new BigDecimal("3.0"));
        assertEquals(operation, response.getOperation());
    }

    @Test
    public void testGetSetOperand1() {
        BigDecimal value = new BigDecimal("3.0");
        OperationResponse response = new OperationResponse("sum", value, new BigDecimal("4.0"), new BigDecimal("7.0"));
        assertEquals(value, response.getOperand1());
    }

    @Test
    public void testGetSetOperand2() {
        BigDecimal value = new BigDecimal("2.0");
        OperationResponse response = new OperationResponse("subtract", new BigDecimal("5.0"), value, new BigDecimal("3.0"));
        assertEquals(value, response.getOperand2());
    }

    @Test
    public void testToString() {
        BigDecimal value1 = new BigDecimal("3.0");
        BigDecimal value2 = new BigDecimal("2.0");
        BigDecimal result = new BigDecimal("5.0");
        String operation = "sum";
        OperationResponse response = new OperationResponse(operation, value1, value2, result);
        String expectedString = "OperationResponse{result=" + result + ", operation='" + operation + '\'' +
                ", operand1=" + value1 + ", operand2=" + value2 + "}";
        assertEquals(expectedString, response.toString());
    }
}

