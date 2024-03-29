package com.example.tienda.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name="laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int ram;
    private int storage;
}
