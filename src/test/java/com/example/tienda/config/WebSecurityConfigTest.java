package com.example.tienda.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class WebSecurityConfigTest {
    @Test
    void BCrypt(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(31);
        String password = passwordEncoder.encode("mohammed");
        log.info(password);
        boolean matches = passwordEncoder.matches("mohammed", password);
        log.info(String.valueOf(matches));
    }
    @Test
    void pbkdf2(){
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        String password = passwordEncoder.encode("mohammed");
        log.info(password);
        boolean matches = passwordEncoder.matches("mohammed", password);
        log.info(String.valueOf(matches));
    }
    @Test
    void argon(){
        Argon2PasswordEncoder  passwordEncoder = new Argon2PasswordEncoder();
        String password = passwordEncoder.encode("mohammed");
        log.info(password);
        boolean matches = passwordEncoder.matches("mohammed", password);
        log.info(String.valueOf(matches));
    }
}