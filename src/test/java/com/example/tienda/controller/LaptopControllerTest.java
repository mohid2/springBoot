package com.example.tienda.controller;

import com.example.tienda.entity.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder=restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate=new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response=testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        List<Laptop>laptops= Arrays.asList(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
        assertEquals(0,laptops.size());
        System.out.println(laptops);
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response=testRestTemplate.getForEntity("/api/laptops/2",Laptop.class);
        assertEquals(null,response.getBody());
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(404,response.getStatusCodeValue());
        System.out.println(response.getBody());
    }

    @Test
    void crear() {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json= """
                {
                        "brand": "nuevo laptop",
                        "model": "ProBook",
                        "ram": 4,
                        "storage": 128
                    }
                """;
        HttpEntity<String> request=new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request, Laptop.class);
        Laptop result=response.getBody();
        assertEquals(1L,result.getId());
        System.out.println(result);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void borrarToldo() {
    }
}