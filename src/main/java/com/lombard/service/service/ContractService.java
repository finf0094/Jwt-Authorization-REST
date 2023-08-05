package com.lombard.service.service;

import com.lombard.service.entities.Client;
import com.lombard.service.entities.Contract;
import com.lombard.service.entities.Product;
import com.lombard.service.exceptions.ContractNotFoundException;
import com.lombard.service.repository.ClientRepository;
import com.lombard.service.repository.ContractRepository;
import com.lombard.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContractService {
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ContractRepository contractRepository;

    public ContractService(ClientRepository clientRepository, ProductRepository productRepository, ContractRepository contractRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.contractRepository = contractRepository;
    }

    public ResponseEntity<Contract> createContract(Client client, Product product) {

        product.calculateLastPaymentDate();
        product.calculateUpdatedSums();

        client = clientRepository.save(client);
        product = productRepository.save(product);




        Contract contract = new Contract();
        contract.setClient(client);
        contract.setProduct(product);

        contractRepository.save(contract);

        return ResponseEntity.ok(contract);
    }

    public List<Contract> getFormedContract() {
        return contractRepository.findByIssuedFalse();
    }

    public boolean deleteIssuedFalseContractById(Long contractId) {
        Contract contract = contractRepository.findByIdAndIssuedFalse(contractId);
        if (contract != null) {
            contractRepository.delete(contract);
            return true;
        }
        return false;
    }

    public Contract getContractById(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);

        return contract.get();
    }

    public Contract toggleIssuedFalseContractToTrue(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);

        contract.get().setIssued(true);

        contractRepository.save(contract.get());

        return contract.get();
    }

    public List<Contract> getContractsByIin(String iin) {
        List<Contract> contracts = contractRepository.findByClientIin(iin);



        return Optional.ofNullable(contracts)
                .orElseThrow(() -> new ContractNotFoundException("No contracts found for the given IIN: " + iin));
    }


}
