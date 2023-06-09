package com.sanitas.calculator.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

@Schema(description = "Error of a calculation", example = "{\"status\": 400, \"error\": \"Bad Request\", \"message\": \"Operands cannot be null\"}")
public class ErrorResponse {

    @Schema(description = "HTTP code", example = "400")
    private int status;
    @Schema(description = "Error", example = "Bad Request")
    private String error;
    @Schema(description = "Message", example = "Operands can't be null")
    private String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
