package com.example.Cifrado2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "car")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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


}
