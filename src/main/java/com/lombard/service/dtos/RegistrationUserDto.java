package com.lombard.service.dtos;

import lombok.Data;


@Data
public class RegistrationUserDto {
    private String username;
    private String fullName;
    private String password;
    private String confirmPassword;
    private String email;
}
