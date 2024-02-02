package com.example.tienda.service;

import com.example.tienda.dto.RegisterRequest;
import com.example.tienda.dto.RegisterResponse;
import com.example.tienda.security.entity.User;


public interface AuthService {
    RegisterResponse register(RegisterRequest request) throws RuntimeException;
}
