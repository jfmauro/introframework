package com.example.introframework.framework;

import com.example.introframework.annotation.CarTag;
import com.example.introframework.entity.Car;
import com.example.introframework.factory.FactoryOfCar;

public class CarStrategy {
    @CarTag
    private FactoryOfCar<? extends Car> factory;

    public Car construct(Long id, String brand, String model){
        Car c = factory.create(id, brand, model);
        return c;
    }
}
