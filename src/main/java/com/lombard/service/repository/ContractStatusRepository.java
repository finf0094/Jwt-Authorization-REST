package com.lombard.service.repository;

import com.lombard.service.entities.ContractStatus;
import org.springframework.data.repository.CrudRepository;

public interface ContractStatusRepository extends CrudRepository<ContractStatus, Integer> {
    ContractStatus findByName(String name);
}
