package com.example.tienda.service;

import com.example.tienda.entity.Laptop;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopService {

    public List<Laptop> findAll();
    public Laptop findOneById(Long id);
    public Laptop create(Laptop laptop);
    public Laptop update(Laptop laptop);
    public boolean delete(Long id);

    public boolean deleteAll();
}
