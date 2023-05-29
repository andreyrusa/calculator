package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.service.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SumOperation implements Operation {
    private static final String OPERATION_NAME = "sum";

    public String getOperationName() {
        return OPERATION_NAME;
    }


    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.add(operand2);
    }


}
