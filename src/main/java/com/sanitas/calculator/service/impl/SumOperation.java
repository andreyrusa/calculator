package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.service.Operation;

import java.math.BigDecimal;

public class SumOperation implements Operation {
    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.add(operand2);
    }
}
