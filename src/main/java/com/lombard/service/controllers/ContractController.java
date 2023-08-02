package com.lombard.service.controllers;

import com.lombard.service.dtos.ContractRequestDto;
import com.lombard.service.entities.Client;
import com.lombard.service.entities.Contract;
import com.lombard.service.entities.Product;
import com.lombard.service.exceptions.AppError;
import com.lombard.service.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping("/create-contract")
    public ResponseEntity<Contract> createNewContract(@RequestBody ContractRequestDto request) {
        if (request.getClient() == null || request.getProduct() == null) {
            // Handle the case where client or product is null, perhaps by returning an error response.
            // For example:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return contractService.createContract(request.getClient(), request.getProduct());
    }

    @GetMapping("/formed-contracts")
    public List<Contract> getFormedContracts() {
        return contractService.getFormedContract();
    }

    @DeleteMapping("/delete-formed-contract/{id}")
    public ResponseEntity<Void> deleteIssuedFalseContractById(@PathVariable Long id) {
        boolean deleted = contractService.deleteIssuedFalseContractById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/contract/{id}")
    public Contract getContract(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @PostMapping("/contract/{id}/print")
    public Contract toggleIssuedFalseContractToTrue(@PathVariable Long id) {
        return contractService.toggleIssuedFalseContractToTrue(id);
    }

    @GetMapping("/find-by-iin/{iin}")
    public List<Contract> getContractByIin(@PathVariable String iin) {
        return contractService.getContractsByIin(iin);
    }

}
