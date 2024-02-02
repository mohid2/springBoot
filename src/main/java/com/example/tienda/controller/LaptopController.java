package com.example.tienda.controller;

import com.example.tienda.entity.Laptop;
import com.example.tienda.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public List<Laptop> findAll() {
        return laptopService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.findOneById(id));
    }

    @PostMapping
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        return ResponseEntity.ok(laptopService.create(laptop));
    }

    @PutMapping
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        return ResponseEntity.ok(laptopService.update(laptop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.delete(id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAll() {
        return ResponseEntity.ok(laptopService.deleteAll());
    }

}
