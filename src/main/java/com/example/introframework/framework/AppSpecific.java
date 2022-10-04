package com.example.introframework.framework;

import com.example.introframework.annotation.CarFactories;
import com.example.introframework.annotation.CarType;
import com.example.introframework.entity.Car;

public class AppSpecific {

    @CarFactories
    private CarStrategy strategy = new CarStrategy();


    public Car getCar(CarType carType, Long id, String brand, String model) throws Exception {
        AppSpecificFramework appSpecificFramework = new AppSpecificFramework();
        appSpecificFramework.configure(this, strategy, carType);

        Car car = strategy.construct(id, brand, model);
        return car;

        /*String name = carFactory.name();
        if (carFactory != null && carFactory.name().equals("SPORT")) {
            return sportCarFactory.create(id, brand, model);
        } else if (carFactory != null && carFactory.name().equals("SUV")) {
            return suvCarFactory.create(id, brand, model);
        } else {
            throw new Exception("define a car type");
        }*/
    }


}
