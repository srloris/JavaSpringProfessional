package com.devsuperior.apirest.mapper;

import com.devsuperior.apirest.dto.ClientDTO;
import com.devsuperior.apirest.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client entity);

    Client toEntity(ClientDTO dto);

    void updateEntityFromDTO(ClientDTO dto, @MappingTarget Client entity);
}
