package com.example.Cifrado2.repositories;

import com.example.Cifrado2.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByDoors(Integer doors);
    List <Car> findByManuFacturerAndModel(String manuFacturer, String model);
    List<Car> findByDoorsGreaterThanEqual(Integer doors);
    List<Car> findByYearBetween(Integer start, Integer end);
    List<Car> findByYear(Integer year);
    List<Car> findByManuFacturer(String manuFacturer);
    List<Car> findByModel(String model);
    List<Car> findByAvailableTrue();

}
