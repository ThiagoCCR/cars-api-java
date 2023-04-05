package com.cars.api.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.api.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
    
}
