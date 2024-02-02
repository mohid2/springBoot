package com.example.tienda.service.impl;

import com.example.tienda.dto.RegisterResponse;
import com.example.tienda.dto.RegisterRequest;
import com.example.tienda.exception.UserRegisterException;
import com.example.tienda.security.entity.Authority;
import com.example.tienda.security.entity.AuthorityName;

import com.example.tienda.security.entity.User;
import com.example.tienda.security.repository.AuthorityRepository;
import com.example.tienda.security.repository.UserRepository;
import com.example.tienda.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository ;

    private final PasswordEncoder passwordEncoder;


    @Override
    public RegisterResponse register(RegisterRequest request)throws RuntimeException {

        if(userRepository.findByUsername(request.getUsername()).isEmpty()){

            List<Authority> roleList = new ArrayList<>();
            Authority role = authorityRepository.findByName(AuthorityName.USER);
            roleList = authorityRepository.findAll();
//            roleList.add(role);
            User u= User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .authorities(roleList)
                    .password(passwordEncoder.encode(request.getPassword())).build();
            userRepository.save(u);
            return RegisterResponse.builder().username(u.getUsername()).massage("Usuario creado").build();
        }
        throw new UserRegisterException("Usuario ya existe");
    }
}
