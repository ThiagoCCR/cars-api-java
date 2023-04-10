package com.cars.api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.api.DTO.CarDTO;
import com.cars.api.api.model.Car;
import com.cars.api.api.repositories.CarRepository;

import jakarta.validation.Valid;

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
    public void Create(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO body) {
        repository.findById(id).map(car -> {
            car.setModelo(body.modelo());
            car.setFabricante(body.fabricante());
            car.setDataFabricacao(body.dataFabricacao());
            car.setAnoModelo(body.anoModelo());
            car.setValor(body.valor());
            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
       repository.deleteById(id);
    }

}
