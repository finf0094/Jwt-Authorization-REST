package com.lombard.service.repository;

import com.lombard.service.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByIssuedFalse();
    @Modifying
    @Query("DELETE FROM Contract c WHERE c.issued = false AND c.id = :contractId")
    void deleteIssuedFalseById(Long contractId);

    Contract findByIdAndIssuedFalse(Long id);

    Optional<Contract> findById(Long id);
}
