package com.lombard.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
}
