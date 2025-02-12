package com.market.market.configs;

import com.market.market.dtos.ExceptionDTO;
import com.market.market.exceptions.ProductNotFoundException;
import com.market.market.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Global exception handler for the application.
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Handles UserNotFoundException and shows a "User not found." message.
     *
     * @return a ResponseEntity containing the exception details with a (404) status code.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(LocalDateTime.now(), exception.getMessage(), exception.getStatusCode());
        return ResponseEntity.status(exception.getStatusCode()).body(exceptionDTO);
    }

    /**
     * Handles ProductNotFoundException and shows a "Product not found." message.
     *
     * @return a ResponseEntity containing the exception details with a (404) status code.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(LocalDateTime.now(), exception.getMessage(), exception.getStatusCode());
        return ResponseEntity.status(exception.getStatusCode()).body(exceptionDTO);
    }

    /**
     * Handles ConstraintViolationException, typically triggered by validation errors
     * when saving or updating data in the database.
     *
     * @return a ResponseEntity with a bad request (400) status and validation error details.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> handleValidationException(ConstraintViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(LocalDateTime.now(), "Validation error: " + exception.getMessage(), 400);
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Handles MethodArgumentNotValidException, which occurs when a request body fails validation.
     *
     * @return a ResponseEntity with a bad request (400) status and a list of validation errors.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleBeanValidationException(MethodArgumentNotValidException exception) {
        StringBuilder errorMessage = new StringBuilder("Validation errors: ");
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            errorMessage.append(String.format("%s; ", message));
        });

        ExceptionDTO exceptionDTO = new ExceptionDTO(LocalDateTime.now(), errorMessage.toString(), 400);
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Handles all other unexpected exceptions and returns an internal server error response.
     *
     * @return a ResponseEntity with an internal server error (500) status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(LocalDateTime.now(), exception.getMessage(), 500);
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
