package com.lombard.service.exceptions;

public class ContractNotFoundException extends RuntimeException{
    public ContractNotFoundException(String message) {
        super(message);
    }
}
