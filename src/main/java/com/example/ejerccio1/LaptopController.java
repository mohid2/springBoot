package com.example.ejerccio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/api/laptops")
    public List<Laptop>findAll(){
        return repository.findAll();
    }
    @PostMapping("api/laptops")
    public Laptop crear(@RequestBody  Laptop laptop){
        return repository.save(laptop);
    }


}
