package com.devsuperior.apirest.mapper;

import com.devsuperior.apirest.dto.ClientDTO;
import com.devsuperior.apirest.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientDTO dto) {
        if(dto == null) return null;

        Client entity = new Client();

        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());

        return entity;
    }

    public ClientDTO toDTO(Client entity) {
        if(entity == null) return null;

        ClientDTO dto = new ClientDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setIncome(entity.getIncome());
        dto.setBirthDate(entity.getBirthDate());
        dto.setChildren(entity.getChildren());

        return dto;
    }
}
