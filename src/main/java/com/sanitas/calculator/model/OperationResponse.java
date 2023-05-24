package com.sanitas.calculator.model;

import java.math.BigDecimal;

public class OperationResponse {

    private BigDecimal result;
    private String operation;
    private BigDecimal operand1;
    private BigDecimal operand2;

    public OperationResponse(String operation, BigDecimal operand1, BigDecimal operand2, BigDecimal result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }


    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getOperand1() {
        return operand1;
    }

    public void setOperand1(BigDecimal operand1) {
        this.operand1 = operand1;
    }

    public BigDecimal getOperand2() {
        return operand2;
    }

    public void setOperand2(BigDecimal operand2) {
        this.operand2 = operand2;
    }

    @Override
    public String toString() {
        return "OperationResponse{" +
                "result=" + result +
                ", operation='" + operation + '\'' +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                '}';
    }
}
