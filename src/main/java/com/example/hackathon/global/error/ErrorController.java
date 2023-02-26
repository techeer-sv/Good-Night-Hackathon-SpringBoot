package com.example.hackathon.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> errorHandler(RuntimeException e) {
        String errorMessage = "An error occurred: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
