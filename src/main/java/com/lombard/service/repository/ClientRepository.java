package com.lombard.service.repository;

import com.lombard.service.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByIin(String iin);
}
