package com.devsuperior.apirest.services;

import com.devsuperior.apirest.dto.ClientDTO;
import com.devsuperior.apirest.entities.Client;
import com.devsuperior.apirest.mapper.ClientMapper;
import com.devsuperior.apirest.repositories.ClientRepository;
import com.devsuperior.apirest.services.exceptions.DatabaseException;
import com.devsuperior.apirest.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

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
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        mapper.updateEntityFromDTO(clientDTO, client);
        Client updated = repository.save(client);
        return mapper.toDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
            repository.flush(); // força a execução imediata
        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure");
        } catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

}
