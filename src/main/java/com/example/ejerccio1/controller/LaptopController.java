package com.example.ejerccio1.controller;

import com.example.ejerccio1.entities.Laptop;
import com.example.ejerccio1.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Laptop>findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> optionalLaptop=repository.findById(id);
        if(optionalLaptop.isPresent()){
            return ResponseEntity.ok(optionalLaptop.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Laptop crear(@RequestBody  Laptop laptop){
        return repository.save(laptop);
    }
    @PutMapping
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        Optional<Laptop> opLaptop=repository.findById(laptop.getId());
        if(laptop.getId()!=null){
            if (opLaptop.isPresent()){
                laptop.setBrand(laptop.getBrand());
                laptop.setModel(laptop.getModel());
                laptop.setRam(laptop.getRam());
                laptop.setStorage(laptop.getStorage());
                return ResponseEntity.ok(repository.save(laptop));
            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping
    public ResponseEntity<Laptop>borrarToldo(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
