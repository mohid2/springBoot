package com.example.ejerccio1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int ram;
    private int storage;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, int ram, int storage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
    }
}
