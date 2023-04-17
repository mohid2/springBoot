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
    LaptopService laptopService;

    @GetMapping
    public List<Laptop>findAll(){
        return laptopService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
       return laptopService.findOneById(id);
    }
    @PostMapping
    public Laptop create(@RequestBody  Laptop laptop){
        return laptopService.create(laptop);
    }
    @PutMapping
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        return laptopService.update(laptop);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        return laptopService.delete(id);
    }
    @DeleteMapping
    public ResponseEntity<Laptop>deleteAll(){
        return laptopService.deleteAll();
    }


}
