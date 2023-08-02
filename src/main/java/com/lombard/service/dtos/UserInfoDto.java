package com.lombard.service.dtos;

import com.lombard.service.entities.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UserInfoDto {
    private String username;
    private String email;
    private List<Role> roles;
}
