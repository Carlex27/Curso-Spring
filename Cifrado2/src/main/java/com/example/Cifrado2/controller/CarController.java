package com.example.Cifrado2.controller;


import com.example.Cifrado2.entities.Car;
import com.example.Cifrado2.service.CarServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {

    @Autowired
    private final CarServiceImpl carService;

    @PostMapping("/addCar")
    public String addCar(
            @RequestBody Car car
            ){
        return carService.addCar(car);
    }

    @PostMapping("/addCars")
    public String addCars(
            @RequestBody List<Car> cars
    ){
        return carService.addCar(cars);
    }


    @GetMapping("/findAll")
    public List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Car> findById(
            @PathVariable Long id
    ){
        return carService.findById(id);
    }
}
