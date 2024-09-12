package com.home.crud_clientes.clientes.controllers;
import com.home.crud_clientes.clientes.dto.ClientDTO;
import com.home.crud_clientes.clientes.entities.Client;
import com.home.crud_clientes.clientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id){

        ClientDTO clientDTO = clientService.findById(id);

        return clientDTO;

    }


    

}