package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.service.Operation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubtractOperation implements Operation {

    private static final String OPERATION_NAME = "subtract";

    public String getOperationName() {
        return OPERATION_NAME;
    }

    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.subtract(operand2);
    }

}
