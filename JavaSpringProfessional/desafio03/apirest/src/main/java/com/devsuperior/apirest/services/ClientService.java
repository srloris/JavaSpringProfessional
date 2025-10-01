package com.devsuperior.apirest.services;

import com.devsuperior.apirest.dto.ClientDTO;
import com.devsuperior.apirest.entities.Client;
import com.devsuperior.apirest.mapper.ClientMapper;
import com.devsuperior.apirest.repositories.ClientRepository;
import com.devsuperior.apirest.services.Expections.DatabaseException;
import com.devsuperior.apirest.services.Expections.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return mapper.toDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = repository.save(mapper.toEntity(clientDTO));
        return mapper.toDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        if(!repository.existsById(id)) throw new ResourceNotFoundException("Resource not found");
        return insert(clientDTO);
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) throw new ResourceNotFoundException("Resource not found");
        try {
            repository.deleteById(id);
        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure");
        }
    }

}
