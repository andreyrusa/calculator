package com.sanitas.calculator;

import com.sanitas.calculator.exception.InvalidOperationException;
import com.sanitas.calculator.exception.NullOperandException;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.service.impl.SubtractOperation;
import com.sanitas.calculator.service.impl.SumOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;
    private SumOperation sumOperation;
    private SubtractOperation subtractOperation;

    @BeforeEach
    public void setUp() {
        sumOperation = Mockito.mock(SumOperation.class);
        subtractOperation = Mockito.mock(SubtractOperation.class);
        when(sumOperation.getOperationName()).thenReturn("sum");
        when(subtractOperation.getOperationName()).thenReturn("subtract");

        calculatorService = new CalculatorService(Arrays.asList(sumOperation, subtractOperation));
    }

    @Test
    public void testCalculateSum() {
        BigDecimal operand1 = new BigDecimal(5);
        BigDecimal operand2 = new BigDecimal(3);
        BigDecimal expected = new BigDecimal(8);

        when(sumOperation.execute(any(), any())).thenReturn(expected);

        BigDecimal result = calculatorService.calculate("sum", operand1, operand2);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateSubtract() {
        BigDecimal operand1 = new BigDecimal(5);
        BigDecimal operand2 = new BigDecimal(3);
        BigDecimal expected = new BigDecimal(2);

        when(subtractOperation.execute(any(), any())).thenReturn(expected);

        BigDecimal result = calculatorService.calculate("subtract", operand1, operand2);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateInvalidOperation() {
        BigDecimal operand1 = new BigDecimal(5);
        BigDecimal operand2 = new BigDecimal(3);

        assertThrows(InvalidOperationException.class, () -> {
            calculatorService.calculate("INVALID", operand1, operand2);
        });
    }

    @Test
    public void testCalculateNullOperands() {
        assertThrows(NullOperandException.class, () -> {
            calculatorService.calculate("sum", null, null);
        });
    }
}
