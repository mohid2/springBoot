package com.example.tienda.service.impl;

import com.example.tienda.security.entity.User;
import com.example.tienda.security.repository.UserRepository;
import com.example.tienda.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private AuthService userService;
    @BeforeEach
    void setUp() {
        User u = User.builder().id(1L).username("mohammed").password("moha").build();
    }
    @Test
    void findByUserName() {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        User u = User.builder().id(1L).username("mohammed").password(passwordEncoder.encode("moha")).build();
        Mockito.when(userRepository.findByUsername("mohammed")).thenReturn(Optional.of(u));
//        User user = UserRepository.findByUsername("mohammed");
//        assertEquals(1,user.getId());
//        assertTrue(passwordEncoder.matches(user.getPassword(),passwordEncoder.encode("moha")));
        boolean moha = passwordEncoder.upgradeEncoding("$2a$10$WeHGS/0I1xz7WVqoDg3NVOq93WLoBDFRC0pU.5LVDAE661w8RyMO.");
//        System.out.println(user);
    }
}