package com.sanitas.calculator.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Response to a calculation", example = "{\"operand1\": 5, \"operand2\": 3}")
public class OperationRequest {

    @Schema(description = "First operand", example = "5")
    private BigDecimal operand1;
    @Schema(description = "Second operand", example = "5")
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
