package com.demo.app.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.app.response.ApiResponse;
import com.demo.app.response.util.ResponseUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(HttpServletRequest request, Exception ex) {
        List<String> errors = Arrays.asList(ex.getMessage());
        ApiResponse<Void> response = ResponseUtil.error(errors, "An error occurred", 1000, request.getRequestURI()); // General error
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        ApiResponse<Void> response = ResponseUtil.error(ex.getMessage(), "Resource not found", 1001, request.getRequestURI()); // Resource not found error
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(HttpServletRequest request, ValidationException ex) {
        ApiResponse<Void> response = ResponseUtil.error(ex.getErrors(), "Validation failed", 1002, request.getRequestURI()); // Validation error
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle other specific exceptions similarly
}