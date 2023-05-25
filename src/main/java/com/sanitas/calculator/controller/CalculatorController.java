package com.sanitas.calculator.controller;

import com.sanitas.calculator.exception.ErrorResponse;
import com.sanitas.calculator.model.OperationRequest;
import com.sanitas.calculator.model.OperationResponse;
import com.sanitas.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping(value = "/v1/api/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final TracerImpl tracer = new TracerImpl();
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/{operation}")
    @Operation(summary = "Operation of two numbers", description = "Returns the result of operating on two given numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved result",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OperationResponse.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<OperationResponse> calculate(
            @Parameter(description = "The type of operation to perform. It can be 'sum' or 'subtract'")
            @PathVariable String operation,

            @Parameter(description = "Request that contains the two operands to operate")
            @RequestBody OperationRequest request) {

        tracer.trace(request.toString());
        BigDecimal result = calculatorService.calculate(operation, request.getOperand1(), request.getOperand2());
        OperationResponse response = new OperationResponse(operation, request.getOperand1(), request.getOperand2(), result);
        tracer.trace(response.toString());
        return ResponseEntity.ok(response);
    }


}
