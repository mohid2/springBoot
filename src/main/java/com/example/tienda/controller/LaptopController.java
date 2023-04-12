package com.example.tienda.controller;

import com.example.tienda.entity.Laptop;
import com.example.tienda.repository.LaptopRepository;
import com.example.tienda.service.IlaptopSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    IlaptopSerice ilaptopSerice;

    @GetMapping
    public List<Laptop>findAll(){
        return ilaptopSerice.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
       return ilaptopSerice.findOneById(id);
    }
    @PostMapping
    public Laptop create(@RequestBody  Laptop laptop){
        return ilaptopSerice.create(laptop);
    }
    @PutMapping
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        return ilaptopSerice.update(laptop);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        return ilaptopSerice.delete(id);
    }
    @DeleteMapping
    public ResponseEntity<Laptop>deleteAll(){
        return ilaptopSerice.deleteAll();
    }


}
