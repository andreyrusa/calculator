package com.sanitas.calculator;

import com.sanitas.calculator.exception.InvalidOperationException;
import com.sanitas.calculator.exception.NullOperandException;
import com.sanitas.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorApplicationTests {

	@Mock
	private CalculatorService calculatorService;

	@Test
	void testCalculateSum() {
		BigDecimal operand1 = new BigDecimal("2.0");
		BigDecimal operand2 = new BigDecimal("3.0");
		BigDecimal thenReturn = new BigDecimal("5.0");
		when(calculatorService.calculate("sum", operand1, operand2)).thenReturn(thenReturn);

		BigDecimal result = calculatorService.calculate("sum", operand1, operand2);

		assertEquals(thenReturn, result);

		verify(calculatorService, times(1)).calculate("sum", operand1, operand2);
	}

	@Test
	void testCalculateSubtract() {
		BigDecimal operand1 = new BigDecimal("3.0");
		BigDecimal operand2 = new BigDecimal("2.0");
		BigDecimal thenReturn = new BigDecimal("1.0");
		when(calculatorService.calculate("subtract", operand1, operand2)).thenReturn(thenReturn);

		BigDecimal result = calculatorService.calculate("subtract", operand1, operand2);

		assertEquals(thenReturn, result);

		verify(calculatorService, times(1)).calculate("subtract", operand1, operand2);
	}

	@Test
	void testCalculateSumWithoutOperands() {
		doThrow(new NullOperandException("Operands cannot be null")).when(calculatorService).calculate("sum", null, null);

		assertThrows(NullOperandException.class, () -> calculatorService.calculate("sum", null, null));

		verify(calculatorService, times(1)).calculate("sum", null, null);
	}

	@Test
	void testCalculateSumWithoutOperation() {
		doThrow(new InvalidOperationException("Invalid operation: mult")).when(calculatorService).calculate("mult", null, null);

		assertThrows(InvalidOperationException.class, () -> calculatorService.calculate("mult", null, null));

		verify(calculatorService, times(1)).calculate("mult", null, null);
	}

	@Test
	void testCalculateInvalidOperation() {
		BigDecimal operand1 = new BigDecimal("3.0");
		BigDecimal operand2 = new BigDecimal("2.0");
		doThrow(new InvalidOperationException("Invalid operation: INVALID")).when(calculatorService).calculate("INVALID", operand1, operand2);

		assertThrows(InvalidOperationException.class, () -> calculatorService.calculate("INVALID", operand1, operand2));

		verify(calculatorService, times(1)).calculate("INVALID", operand1, operand2);
	}

}
