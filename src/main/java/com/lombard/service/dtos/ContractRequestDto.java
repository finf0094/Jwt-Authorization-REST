package com.lombard.service.dtos;

import com.lombard.service.entities.Client;
import com.lombard.service.entities.Product;
import lombok.Data;

@Data
public class ContractRequestDto {
    private Client client;
    private Product product;
}
