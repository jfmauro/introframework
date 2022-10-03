package com.example.introframework.factory;

import com.example.introframework.entity.Suv;

public class SuvFactory implements FactoryOfCar<Suv> {

    @Override
    public Suv create(Long id, String brand, String model) {
        return new Suv(id, brand, model);
    }
}
