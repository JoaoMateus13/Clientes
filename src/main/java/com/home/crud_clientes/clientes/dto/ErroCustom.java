package com.home.crud_clientes.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;


@Getter
@AllArgsConstructor
public class ErroCustom {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;


    
}
