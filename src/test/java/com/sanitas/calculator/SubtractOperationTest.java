package com.sanitas.calculator;

import com.sanitas.calculator.service.impl.SubtractOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractOperationTest {

    private SubtractOperation subtractOperation;

    @BeforeEach
    public void setUp() {
        subtractOperation = new SubtractOperation();
    }

    @Test
    public void testGetOperationName() {
        assertEquals("subtract", subtractOperation.getOperationName());
    }

    @Test
    public void testExecute() {
        BigDecimal operand1 = new BigDecimal(5);
        BigDecimal operand2 = new BigDecimal(3);
        BigDecimal expected = new BigDecimal(2);

        BigDecimal result = subtractOperation.execute(operand1, operand2);

        assertEquals(expected, result);
    }
}