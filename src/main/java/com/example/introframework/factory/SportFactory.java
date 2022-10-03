package com.example.introframework.factory;

import com.example.introframework.entity.Sport;

public class SportFactory implements FactoryOfCar<Sport> {

    @Override
    public Sport create(Long id, String brand, String model) {
        return new Sport(id, brand, model);
    }
}
