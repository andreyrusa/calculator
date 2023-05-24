package com.sanitas.calculator.service;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal execute(BigDecimal operand1, BigDecimal operand2);

}
