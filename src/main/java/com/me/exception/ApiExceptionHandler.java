
package com.me.exception;

import lombok.extern.log4j.Log4j2;

import org.hibernate.exception.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
public class ApiExceptionHandler {

    @ExceptionHandler(AccountOwnerNotExistsException.class)
    ProblemDetail notFound(AccountOwnerNotExistsException exception) {
        log.warn("Account owner not found: {}", exception.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(AccountOwnerAlreadyExists.class)
    ProblemDetail notFound(AccountOwnerAlreadyExists exception) {
        log.warn("Account owner already exists: {}", exception.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        log.warn("Request validation failed: {}", errors);

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrity(DataIntegrityViolationException ex) {

        String constraint = ex.getCause() instanceof ConstraintViolationException cve
                ? cve.getConstraintName()
                : null;

        ProblemDetail problem = switch (String.valueOf(constraint)) {
            case "uk_account_orders_payment_code" ->
                    ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "This payment code was already used.");
            case "ck_account_orders_price_non_negative" ->
                    ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Price cannot be negative.");
            default ->
                    ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "The request conflicts with existing data.");
        };

        log.warn("Data integrity violation, constraint={}", constraint);
        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpected(Exception ex) {

        log.error("Unexpected error", ex);

        return ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Something went wrong. Please try again later."
        );
    }
}
