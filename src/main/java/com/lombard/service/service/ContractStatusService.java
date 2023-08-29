package com.lombard.service.service;

import com.lombard.service.entities.ContractStatus;
import com.lombard.service.repository.ContractStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractStatusService {
    private final ContractStatusRepository contractStatusRepository;

    public ContractStatus getFormedStatus() {
        return contractStatusRepository.findByName("formed");
    }

    public ContractStatus getIssuedContract() {
        return contractStatusRepository.findByName("issued");
    }
}
