package com.example.tienda.service;

import com.example.tienda.entity.Laptop;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopService {

    public List<Laptop> findAll();
    public ResponseEntity<Laptop> findOneById(Long id);
    public Laptop create(Laptop laptop);
    public ResponseEntity<Laptop> update(Laptop laptop);
    public ResponseEntity<Laptop> delete(Long id);

    public ResponseEntity<Laptop> deleteAll();
}
