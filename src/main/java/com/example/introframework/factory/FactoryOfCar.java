package com.example.introframework.factory;

import com.example.introframework.entity.Car;

public interface FactoryOfCar<T extends Car> {
    T create(Long id, String brand, String model);
}
