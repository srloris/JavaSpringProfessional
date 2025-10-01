package com.devsuperior.apirest.repositories;

import com.devsuperior.apirest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
