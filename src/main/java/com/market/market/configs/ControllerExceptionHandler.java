package com.market.market.configs;

import com.market.market.dtos.ExceptionDTO;
import com.market.market.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), exception.getStatusCode());
        return ResponseEntity.status(exception.getStatusCode()).body(exceptionDTO);
    }

    // Validate BEAN annotations during save or update of data in the database
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> handleValidationException(ConstraintViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Validation error: " + exception.getMessage(), 400);
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    // Validate BEAN annotations when an object is invalid as an argument of an endpoint
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleBeanValidationException(MethodArgumentNotValidException exception) {
        StringBuilder errorMessage = new StringBuilder("Validation errors: ");
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            errorMessage.append(String.format("%s; ", message));
        });

        ExceptionDTO exceptionDTO = new ExceptionDTO(errorMessage.toString(), 400);
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    // Generals exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), 500);
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
