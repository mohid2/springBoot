package com.example.tienda.controller;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



import java.util.HashMap;

import java.util.Map;

@RestController
public class PruebaController {
    @GetMapping("/")
    public Map<String, Object> saluda() {
        Map<String,Object> roles= new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        roles.put("username",authentication.getName());
        roles.put("roles ",authentication.getAuthorities());
        roles.put("Details",authentication.getDetails().toString());
        return roles ;
    }
}
