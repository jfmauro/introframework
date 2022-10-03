package com.example.introframework.factory;

public interface FactoryOfCar<T> {
    T create(Long id, String brand, String model);
}
