package com.sanitas.calculator.service;

import com.sanitas.calculator.exception.InvalidOperationException;
import com.sanitas.calculator.exception.NullOperandException;
import com.sanitas.calculator.service.impl.SubtractOperation;
import com.sanitas.calculator.service.impl.SumOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorService {

    private final Map<String, Operation> operations = new HashMap<>();


    public CalculatorService() {
        operations.put("sum", new SumOperation());
        operations.put("subtract", new SubtractOperation());
        // Add more operations here ...
    }


    public BigDecimal calculate(String operationName, BigDecimal operand1, BigDecimal operand2) {
        Operation operation = operations.get(operationName);
        if (operation == null) {
            throw new InvalidOperationException("Invalid operation: " + operationName);
        } else if (operand1 == null || operand2 == null) {
            throw new NullOperandException("Operands cannot be null");
        }else return operation.execute(operand1, operand2);
    }

}
