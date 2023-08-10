package com.lombard.service.controllers;


import com.lombard.service.entities.User;
import com.lombard.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping ("/set-admin-role/{id}")
    public User setAdminRole(@PathVariable Long id) {
        return userService.setAdminRole(id);
    }

}
