package com.example.Cifrado2.service;

import com.example.Cifrado2.entities.Car;
import com.example.Cifrado2.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;


@AllArgsConstructor
@Service
public class CarServiceImpl{
    private static final Integer MIN_DOORS=3;

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    public String addCar(Car car){
        carRepository.save(car);
        return "Car added succesfully";
    }
    public String addCar(List<Car> cars){
        carRepository.saveAll(cars);
        return "Car added succesfully";
    }

    public List<Car> findAll() {
        log.info("Executing findAll method");
        return carRepository.findAll();
    }


    public Optional<Car> findById(Long id) {
        log.info("Executing findById method");
        return carRepository.findById(id);
    }


    public Long count() {
        log.info("Executing count method");
        return carRepository.count();
    }


    public Car save(Car car) {
        log.info("Executing save method");
        if(!carValidation(car)){
            log.warn("The car is not valid");
            return null;
        }
        return carRepository.save(car);
    }


    public void deleteById(Long id) {
        log.info("Executing deleteById method");
        if(id == null || id < 0 || id==0 ){
            log.warn("The id is not valid");
            return;
        }
        try{
            carRepository.deleteById(id);
        }catch (Exception e){
            log.error("An error occurred while deleting the car {}");
        }

    }


    public void deleteAll() {
        log.info("Executing deleteAll method");
        carRepository.deleteAll();
    }


    public void deleteAll(List<Car> cars) {
        log.info("Executing deleteAll(List<> cars) method");
        if (CollectionUtils.isEmpty(cars)) {
            log.warn("The list of cars is empty");
            return;
        }
        carRepository.deleteAll(cars);
    }


    public void deleteAllById(List<Long> ids) {
        log.info("Executing deleteAllById(List<> ids) method");
        if (CollectionUtils.isEmpty(ids)) {
            log.warn("The list of ids is empty");
            return;
        }
        carRepository.deleteAllById(ids);
    }


    public List<Car> findByDoors(Integer doors) {
        log.info("Executing findByDoors method");
        if(doors<MIN_DOORS){
            log.warn("The number of doors is less than the minimum allowed");
            return new ArrayList<>();
        }
        return carRepository.findByDoors(doors);
    }


    public List<Car> findByManuFacturerAndModel(String manuFacturer, String model) {
        log.info("Executing findByManuFacturerAndModel method");
        if(!StringUtils.hasLength(manuFacturer) || !StringUtils.hasLength(model)){
            log.warn("The manufacturer or model is empty");
            return new ArrayList<>();
        }
        return carRepository.findByManuFacturerAndModel(manuFacturer, model);
    }


    public List<Car> findByDoorsGreaterThanEqual(Integer doors) {
        log.info("Executing findByDoorsGreaterThanEqual method");
        if(doors == null || doors < 0){
            log.warn("The number of doors is less than the minimum allowed");
            return new ArrayList<>();
        }

        return carRepository.findByDoorsGreaterThanEqual(doors);
    }


    public List<Car> findByDoorsLessThanEqual(Integer doors) {
        return List.of();
    }


    public List<Car> findByYearBetween(Integer start, Integer end) {
        log.info("Executing findByYearBetween method");
        return carRepository.findByYearBetween(start, end);
    }


    public List<Car> findByYear(Integer year) {
        log.info("Executing findByYear method");
        if (year == null || year < 0) {
            log.warn("The year is less than the minimum allowed");
            return new ArrayList<>();
        }
        return carRepository.findByYear(year);
    }


    public List<Car> findByManuFacturer(String manuFacturer) {
        log.info("Executing findByManuFacturer method");
        if (!StringUtils.hasLength(manuFacturer)) {
            log.warn("The manufacturer is empty");
            return new ArrayList<>();
        }
        return carRepository.findByManuFacturer(manuFacturer);
    }


    public List<Car> findByModel(String model) {
        log.info("Executing findByModel method");
        if (!StringUtils.hasLength(model)) {
            log.warn("The model is empty");
            return new ArrayList<>();
        }
        return carRepository.findByModel(model);
    }


    public List<Car> findByAvailableTrue() {
        log.info("Executing findByAvailableTrue method");
        return carRepository.findByAvailableTrue();
    }


    //Car validation
    private boolean carValidation(Car car){
        //Car null validation
        if(carRepository==null){
            log.error("The car repository is null");
            return false;
        }
        //doors validation
        if(car.getDoors() == null || car.getDoors() < MIN_DOORS){
            log.warn("The number of doors is less than the minimum allowed");
            return false;
        }
        //Color validation

        return true;
    }
}
