package com.example.tienda.service.impl;

import com.example.tienda.entity.Laptop;
import com.example.tienda.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements com.example.tienda.service.LaptopService {
    @Autowired
    LaptopRepository repository;


    @Override
    public List<Laptop> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Laptop> findOneById(Long id) {
        Optional<Laptop> optionalLaptop=repository.findById(id);
        if(optionalLaptop.isPresent()){
            return ResponseEntity.ok(optionalLaptop.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Laptop create(Laptop laptop) {
        return repository.save(laptop);
    }

    @Override
    public ResponseEntity<Laptop> update(Laptop laptop) {
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

    @Override
    public ResponseEntity<Laptop> delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Laptop> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
