package com.cars.api.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.api.DTO.CarDTO;

@RestController
@RequestMapping("/api/car")
public class CarsController {

    @PostMapping
    public void Create(@RequestBody CarDTO req) {
        System.out.println(req);
    }

}
