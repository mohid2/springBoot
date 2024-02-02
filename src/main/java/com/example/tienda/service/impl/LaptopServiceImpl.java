package com.example.tienda.service.impl;

import com.example.tienda.entity.Laptop;
import com.example.tienda.exception.NotFoundLaptopException;
import com.example.tienda.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements com.example.tienda.service.LaptopService {

    private final LaptopRepository repository;


    @Override
    public List<Laptop> findAll() {
        return repository.findAll();
    }

    @Override
    public Laptop findOneById(Long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundLaptopException("El laptop con el "+id+" no existe"));
    }

    @Override
    public Laptop create(Laptop laptop) {
        return repository.save(laptop);
    }

    @Override
    public Laptop update(Laptop laptop) {
        Optional<Laptop> opLaptop=repository.findById(laptop.getId());
        if(laptop.getId()!=null){
            if (opLaptop.isPresent()){
                laptop.setBrand(laptop.getBrand());
                laptop.setModel(laptop.getModel());
                laptop.setRam(laptop.getRam());
                laptop.setStorage(laptop.getStorage());
                return repository.save(laptop);
            }
    }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
            return false;
    }

    @Override
    public boolean deleteAll() {
        repository.deleteAll();
        return true;
    }
}
