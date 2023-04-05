package com.cars.api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.api.DTO.CarDTO;
import com.cars.api.api.model.Car;
import com.cars.api.api.repositories.CarRepository;

@RestController
@RequestMapping("/api/car")
public class CarsController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void Create(@RequestBody CarDTO req) {
        repository.save(new Car(req));
    }

}
