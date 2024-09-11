package com.home.crud_clientes.clientes.dto;

import java.time.LocalDate;

import com.home.crud_clientes.clientes.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    @NotBlank(message = "Não pode ser vazio")
    private String name;
    @NotBlank(message = "Campo obrigatório")
    private String cpf;
    private Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser futura")
    private LocalDate birthData;
    private Integer children;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthData = client.getBirthData();
        this.children = client.getChildren();
    }

}
