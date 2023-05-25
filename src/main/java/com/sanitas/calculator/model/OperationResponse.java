package com.sanitas.calculator.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Response to a calculation", example = "{\"result\": 8, \"operation\": \"sum\", \"operand1\": 5, \"operand2\": 3}")
public class OperationResponse {

    @Schema(description = "Operation result", example = "8")
    private BigDecimal result;

    @Schema(description = "Type of operation performed", example = "sum")
    private String operation;

    @Schema(description = "First operand", example = "5")
    private BigDecimal operand1;

    @Schema(description = "Second operand", example = "3")
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
