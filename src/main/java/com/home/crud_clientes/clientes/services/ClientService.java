package com.home.crud_clientes.clientes.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.home.crud_clientes.clientes.dto.ClientDTO;
import com.home.crud_clientes.clientes.entities.Client;
import com.home.crud_clientes.clientes.repositories.ClientRepository;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Busca de recurso por id
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    // Busca paginada de recursos
    @Transactional(readOnly = true)
    
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> listClient = clientRepository.findAll(pageable);
        return listClient.map(x -> new ClientDTO(x));
    }


    // Inserir novo recurso.

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        /*Adicionar depois 

        if(clientRepository.findByCpf(dto.getCpf()) != null){
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        */
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);

    }


    // Atualizar recurso

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){


    //try{
        Client client = clientRepository.getReferenceById(id);
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    /*
    }
    catch (Exception e){
        throw new IllegalArgumentException("Cliente não encontrado");
    }
        */
        
    }



    // Deletar recurso

    @Transactional(propagation = Propagation.SUPPORTS)

    public void delete(Long id){
        clientRepository.deleteById(id);
    }



    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }
    
    


}
