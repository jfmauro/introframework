package com.example.introframework.framework;

import com.example.introframework.annotation.CarFactories;
import com.example.introframework.annotation.CarFactory;
import com.example.introframework.entity.Car;
import com.example.introframework.entity.Sport;
import com.example.introframework.entity.Suv;
import com.example.introframework.factory.FactoryOfCar;

public class AppSpecific {
    @CarFactories(name = CarFactory.SUV)
    private FactoryOfCar<Suv> suvCarFactory;

    @CarFactories(name = CarFactory.SPORT)
    private FactoryOfCar<Sport> sportCarFactory;

    public void configure (CarFactory carFactory) throws IllegalAccessException {
        AppSpecificFramework appSpecificFramework = new AppSpecificFramework();
        appSpecificFramework.configure (this, carFactory);
    }

    public Suv getSuv(Long id, String brand, String model) throws Exception{
        if (suvCarFactory !=null)
            return suvCarFactory.create(id, brand, model);
        else
            throw new Exception("factory is null.");
    }

    public Sport getSport(Long id, String brand, String model) throws Exception{
        if (sportCarFactory !=null)
            return sportCarFactory.create(id, brand, model);
        else
            throw new Exception("factory is null.");
    }


}
