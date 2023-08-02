package com.lombard.service.controllers;

import com.lombard.service.dtos.JwtResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/info")
    public JwtResponse info() {
        return new JwtResponse("askha", "3o2,d43imfoi34mfoc4i3icm3jrofmj3lrmf");
    }
}
