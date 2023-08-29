package com.lombard.service.controllers;

import com.lombard.service.dtos.JwtRequest;
import com.lombard.service.dtos.RegistrationUserDto;
import com.lombard.service.dtos.UserInfoDto;
import com.lombard.service.entities.User;
import com.lombard.service.service.AuthService;
import com.lombard.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }

    @GetMapping("/user-information")
    public ResponseEntity<?> getUserInformation() {
        // получаем из фильтра данные ползователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // если не авторизован выкидываем ошибку
        if (!authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // находим в базе пользователя
        User user = userService.findByUserName(authentication.getPrincipal().toString()).orElseThrow();

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(user.getUsername());
        userInfoDto.setEmail(user.getEmail());
        userInfoDto.setRoles(new ArrayList<>(user.getRoles()));
        userInfoDto.setTotalAmountIssued(user.getTotalAmountIssued());
        userInfoDto.setFullName(user.getFullName());

        return ResponseEntity.ok(userInfoDto);
    }



}
