package com.home.crud_clientes.clientes.controllers.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.home.crud_clientes.clientes.dto.ErroCustom;
import com.home.crud_clientes.clientes.dto.ValidationError;
import com.home.crud_clientes.clientes.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroCustom> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustom error = new ErroCustom(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroCustom> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());

        
        for (FieldError f : e.getBindingResult().getFieldErrors()){
            error.addError(f.getField(), f.getDefaultMessage());
        }
        
        return ResponseEntity.status(status).body(error);
    }

}
