package com.sanitas.calculator.controller;

import com.sanitas.calculator.model.OperationRequest;
import com.sanitas.calculator.model.OperationResponse;
import com.sanitas.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/v1/api/calculate")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final TracerImpl tracer = new TracerImpl();
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/{operation}")
    @Operation(summary = "Realiza una operación", description = "Realiza una operación con dos operandos")
    public ResponseEntity<OperationResponse> calculate(@PathVariable String operation, @RequestBody OperationRequest request) {
        BigDecimal result = calculatorService.calculate(operation, request.getOperand1(), request.getOperand2());
        OperationResponse response = new OperationResponse(operation, request.getOperand1(), request.getOperand2(), result);
        tracer.trace(response.toString());
        return ResponseEntity.ok(response);
    }

}
