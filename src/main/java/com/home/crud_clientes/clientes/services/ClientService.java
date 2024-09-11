package com.home.crud_clientes.clientes.services;
import com.home.crud_clientes.clientes.dto.ClientDTO;
import com.home.crud_clientes.clientes.entities.Client;
import com.home.crud_clientes.clientes.repositories.ClientRepository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository ClientRepository;

    @Transactional
    public ClientDTO insert(ClientDTO dto) {

        
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
    }


    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        return null;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {

        Client client = ClientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return null;
    }

    

    
    


}
