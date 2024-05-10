package com.whatsappapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatsappapi.api.dto.AuthenticationRequest;
import com.whatsappapi.api.dto.UserRegistrationRequest;
import com.whatsappapi.api.service.AuthService;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {

        ResponseEntity<?> responseEntity = authService.registerUser(request);
        return authService.registerUser(request);
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) {

        ResponseEntity<?> response = new ResponseEntity<>(authService.authenticateUser(request),
                responseEntity.getHeaders(), responseEntity
                .getStatusCode());
        return authService.authenticateUser(request);
    }
}

