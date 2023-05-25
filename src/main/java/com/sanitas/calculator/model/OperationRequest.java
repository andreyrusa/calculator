package com.sanitas.calculator.model;

import java.math.BigDecimal;

public class OperationRequest {

    private BigDecimal operand1;
    private BigDecimal operand2;

    public OperationRequest(BigDecimal operand1, BigDecimal operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public OperationRequest() {
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
        return "OperationRequest{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                '}';
    }
}
