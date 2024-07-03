package com.example.Cifrado2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fabricante")
    private String manuFacturer;
    private String model;
    private Double cc;
    private Integer doors;

    @Column(name = "year of manufacture")
    private Integer year;
    private LocalDate realeseDate;
    private Boolean available;

    public Car() {
    }

    public Car(Long id, String manuFacturer, String model, Double cc, Integer doors, Integer year, LocalDate realeseDate, Boolean available) {
        this.id = id;
        this.manuFacturer = manuFacturer;
        this.model = model;
        this.cc = cc;
        this.doors = doors;
        this.year = year;
        this.realeseDate = realeseDate;
        this.available = available;
    }

}
