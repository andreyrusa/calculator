package com.sanitas.calculator;

import com.sanitas.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CalculatorApplicationTests {

	private CalculatorService calculatorService = new CalculatorService();

	@Test
	public void testSum() {
		assertEquals(new BigDecimal("5"), calculatorService.calculate("sum", new BigDecimal("3"), new BigDecimal("2")));
	}

	@Test
	public void testSubtract() {
		assertEquals(new BigDecimal("1"), calculatorService.calculate("subtract", new BigDecimal("3"), new BigDecimal("2")));
	}

}
