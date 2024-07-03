package com.example.Cifrado2.dto;


import com.example.Cifrado2.entities.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Data transfer object for the list of cars
 */
@Setter
@Getter
public class CarListDTO {
    private List<Car> cars;

    public CarListDTO() {
    }

}
