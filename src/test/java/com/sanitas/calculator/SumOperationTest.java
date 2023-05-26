package com.sanitas.calculator;

import com.sanitas.calculator.service.impl.SumOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOperationTest {

    private SumOperation sumOperation;

    @BeforeEach
    public void setUp() {
        sumOperation = new SumOperation();
    }

    @Test
    public void testGetOperationName() {
        assertEquals("sum", sumOperation.getOperationName());
    }

    @Test
    public void testExecute() {
        BigDecimal operand1 = new BigDecimal(5);
        BigDecimal operand2 = new BigDecimal(3);
        BigDecimal expected = new BigDecimal(8);

        BigDecimal result = sumOperation.execute(operand1, operand2);

        assertEquals(expected, result);
    }
}