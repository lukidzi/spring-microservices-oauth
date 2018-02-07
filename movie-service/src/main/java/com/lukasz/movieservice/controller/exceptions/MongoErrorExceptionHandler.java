package com.lukasz.movieservice.controller.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MongoErrorExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(MongoErrorExceptionHandler.class);

    @ExceptionHandler(value = DuplicateKeyException.class)
    protected ResponseEntity<String> handleDuplicate(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot insert duplicated item: " + ex.getMessage());
    }
}
