package com.home.crud_clientes.clientes.services;
import com.home.crud_clientes.clientes.dto.ClientDTO;
import com.home.crud_clientes.clientes.entities.Client;
import com.home.crud_clientes.clientes.repositories.ClientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {

        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }


    
    


}
