package com.mark.restaurant.menu.api.controllers;

import com.mark.restaurant.menu.api.dto.AuthenticationDto;
import com.mark.restaurant.menu.api.dto.LoginResponseDto;
import com.mark.restaurant.menu.api.dto.RegisterDto;
import com.mark.restaurant.menu.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid AuthenticationDto data) {
        LoginResponseDto response = authService.login(data);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDto data) {
        authService.register(data);
        return ResponseEntity.ok().build();
    }
}