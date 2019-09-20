package com.helios.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ComputeServiceErrorAdvice {

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<String> handleIllegalStateException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, "Получена неподдерживаемая операция");
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, "Нет цифры в базе данных");
    }

    private ResponseEntity<String> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(message);
    }
}
