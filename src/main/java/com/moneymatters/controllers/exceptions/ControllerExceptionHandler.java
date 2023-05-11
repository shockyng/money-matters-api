package com.moneymatters.controllers.exceptions;

import com.moneymatters.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Method argument not valid";
        StandardError err = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        String errors = "Existing resource";

        StandardError err = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), errors, e.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(err);
    }
}