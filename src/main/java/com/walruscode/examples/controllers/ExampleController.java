package com.walruscode.examples.controllers;

import com.walruscode.examples.dto.Car;
import com.walruscode.examples.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final CarService carService;

    @GetMapping("/example")
    Car getCar() {

        Car car = new Car(4, "Audi");
        carService.consumeCar(car);

        return car;
    }
}
