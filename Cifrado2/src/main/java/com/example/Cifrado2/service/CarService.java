package com.example.Cifrado2.service;

import com.example.Cifrado2.entities.Car;
import java.util.List;
import java.util.Optional;


public interface CarService {
    //Spring repository methods

    List<Car> findAll();
    Optional<Car> findById(Long id);
    Long count();
    Car save(Car car);
    void deleteById(Long id);
    void deleteAll();
    void deleteAll(List<Car> cars);
    void deleteAllById(List<Long> ids);

    //Custom methods
    List<Car> findByDoors(Integer doors);
    List <Car> findByManuFacturerAndModel(String manuFacturer, String model);
    List<Car> findByDoorsGreaterThanEqual(Integer doors);
    List<Car> findByDoorsLessThanEqual(Integer doors);
    List<Car> findByYearBetween(Integer start, Integer end);
    List<Car> findByYear(Integer year);
    List<Car> findByManuFacturer(String manuFacturer);
    List<Car> findByModel(String model);
    List<Car> findByAvailableTrue(Boolean available);
    Long deleteByAllAvailableFalse();
}
