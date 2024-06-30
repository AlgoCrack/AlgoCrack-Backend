package com.auth.config;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.auth.vo.ApiResponse;
import com.netflix.discovery.shared.transport.TransportException;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // object constraint error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        String errString = errors.toString();
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), errString, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // connect to the eureka server error
    @ExceptionHandler(TransportException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationExceptions(TransportException ex) {
        log.error("eureka server connection failed", ex);
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage(), "SERVICE_UNAVAILABLE");
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    // unexpected exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
