package com.home.crud_clientes.clientes.dto;

import java.time.Instant;

import java.util.*;


public class ValidationError extends ErroCustom {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);

    }

    public List<FieldMessage> getErros(){
        return erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
    
}
