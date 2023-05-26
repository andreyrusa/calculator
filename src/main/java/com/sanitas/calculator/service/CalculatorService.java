package com.sanitas.calculator.service;

import com.sanitas.calculator.exception.InvalidOperationException;
import com.sanitas.calculator.exception.NullOperandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    private final Map<String, Operation> operations;

    @Autowired
    public CalculatorService(List<Operation> operationList) {
        this.operations = operationList.stream()
                .collect(Collectors.toMap(
                        Operation::getOperationName,
                        Function.identity()));
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
