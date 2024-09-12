

package com.home.crud_clientes.clientes.repositories;
import com.home.crud_clientes.clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Object findByCpf(String cpf);
}
