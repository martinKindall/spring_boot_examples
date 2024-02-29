package com.walruscode.examples.services;

import com.walruscode.examples.dto.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarService {

    public void consumeCar(Car car) {
        log.info("The car brand is {}", car.brand());
    }
}
