package com.lombard.service.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
