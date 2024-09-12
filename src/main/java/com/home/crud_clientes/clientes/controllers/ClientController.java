package com.home.crud_clientes.clientes.controllers;
import com.home.crud_clientes.clientes.dto.ClientDTO;
import com.home.crud_clientes.clientes.entities.Client;
import com.home.crud_clientes.clientes.services.ClientService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;



    // Busca paginada de recursos
    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        Page<ClientDTO> list = clientService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }


    //Busca de recurso por id

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){

        ClientDTO clientDTO = clientService.findById(id);

        return ResponseEntity.ok(clientDTO);
    }


    // Inserir novo recurso

    @PostMapping(value = "/save")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO){

        ClientDTO dto = clientService.insert(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
        
    }

    // Atualizar recurso

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto){
        dto = clientService.update(id, dto);
        return ResponseEntity.ok().body(dto);

    }


    // Deletar recurso

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }





}