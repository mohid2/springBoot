package com.example.tienda.controller;

import com.example.tienda.dto.RegisterRequest;

import com.example.tienda.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private final AuthService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
}
