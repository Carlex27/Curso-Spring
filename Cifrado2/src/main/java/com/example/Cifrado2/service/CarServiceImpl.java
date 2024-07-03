package com.example.Cifrado2.service;

import com.example.Cifrado2.entities.Car;
import com.example.Cifrado2.repositories.CarRepository;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CarServiceImpl implements CarService{
    private static final Integer MIN_DOORS=3;

    private final Logger log = (Logger) LoggerFactory.getLogger(CarServiceImpl.class);

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        log.info("Executing findAll method");
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        log.info("Executing findById method");
        return carRepository.findById(id);
    }

    @Override
    public Long count() {
        log.info("Executing count method");
        return carRepository.count();
    }

    @Override
    public Car save(Car car) {
        log.info("Executing save method");
        if(!carValidation(car)){
            log.warning("The car is not valid");
            return null;
        }
        Car carDB = carRepository.save(car);
        return carDB;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Executing deleteById method");
        if(id == null || id < 0 || id==0 ){
            log.warning("The id is not valid");
            return;
        }
        try{
            carRepository.deleteById(id);
        }catch (Exception e){
            log.severe("An error occurred while deleting the car {}");
        }

    }

    @Override
    public void deleteAll() {
        log.info("Executing deleteAll method");
        carRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<Car> cars) {
        log.info("Executing deleteAll(List<> cars) method");
        if (CollectionUtils.isEmpty(cars)) {
            log.warning("The list of cars is empty");
            return;
        }
        carRepository.deleteAll(cars);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        log.info("Executing deleteAllById(List<> ids) method");
        if (CollectionUtils.isEmpty(ids)) {
            log.warning("The list of ids is empty");
            return;
        }
        carRepository.deleteAllById(ids);
    }

    @Override
    public List<Car> findByDoors(Integer doors) {
        log.info("Executing findByDoors method");
        if(doors<MIN_DOORS){
            log.warning("The number of doors is less than the minimum allowed");
            return new ArrayList<>();
        }
        return carRepository.findByDoors(doors);
    }

    @Override
    public List<Car> findByManuFacturerAndModel(String manuFacturer, String model) {
        log.info("Executing findByManuFacturerAndModel method");
        if(!StringUtils.hasLength(manuFacturer) || !StringUtils.hasLength(model)){
            log.warning("The manufacturer or model is empty");
            return new ArrayList<>();
        }
        return carRepository.findByManuFacturerAndModel(manuFacturer, model);
    }

    @Override
    public List<Car> findByDoorsGreaterThanEqual(Integer doors) {
        log.info("Executing findByDoorsGreaterThanEqual method");
        if(doors == null || doors < 0){
            log.warning("The number of doors is less than the minimum allowed");
            return new ArrayList<>();
        }

        return carRepository.findByDoorsGreaterThanEqual(doors);
    }

    @Override
    public List<Car> findByDoorsLessThanEqual(Integer doors) {
        return List.of();
    }

    @Override
    public List<Car> findByYearBetween(Integer start, Integer end) {
        log.info("Executing findByYearBetween method");
        return carRepository.findByYearBetween(start, end);
    }

    @Override
    public List<Car> findByYear(Integer year) {
        log.info("Executing findByYear method");
        if (year == null || year < 0) {
            log.warning("The year is less than the minimum allowed");
            return new ArrayList<>();
        }
        return carRepository.findByYear(year);
    }

    @Override
    public List<Car> findByManuFacturer(String manuFacturer) {
        log.info("Executing findByManuFacturer method");
        if (!StringUtils.hasLength(manuFacturer)) {
            log.warning("The manufacturer is empty");
            return new ArrayList<>();
        }
        return carRepository.findByManuFacturer(manuFacturer);
    }

    @Override
    public List<Car> findByModel(String model) {
        log.info("Executing findByModel method");
        if (!StringUtils.hasLength(model)) {
            log.warning("The model is empty");
            return new ArrayList<>();
        }
        return carRepository.findByModel(model);
    }

    @Override
    public List<Car> findByAvailableTrue(Boolean available) {
        log.info("Executing findByAvailableTrue method");
        if (available == null) {
            log.warning("The available is null");
            return new ArrayList<>();
        }
        return carRepository.findByAvailableTrue(available);
    }

    @Override
    public Long deleteByAllAvailableFalse() {
        log.info("Executing deleteByAllAvailableFalse method");
        return carRepository.deleteByAllAvailableFalse();
    }

    //Car validation
    private boolean carValidation(Car car){
        //Car null validation
        if(carRepository==null){
            log.severe("The car repository is null");
            return false;
        }
        //doors validation
        if(car.getDoors() == null || car.getDoors() < MIN_DOORS){
            log.warning("The number of doors is less than the minimum allowed");
            return false;
        }
        //Color validation

        return true;
    }
}
