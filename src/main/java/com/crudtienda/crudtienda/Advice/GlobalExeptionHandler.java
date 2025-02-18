package com.crudtienda.crudtienda.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<messageError> handleRuntimeExeption(RuntimeException ex){
            messageError newMessage = new messageError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(newMessage, HttpStatus.NOT_FOUND);
        }
}
