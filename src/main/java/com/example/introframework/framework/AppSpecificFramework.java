package com.example.introframework.framework;

import com.example.introframework.annotation.CarFactories;
import com.example.introframework.annotation.CarFactory;
import com.example.introframework.entity.Car;
import com.example.introframework.factory.FactoryOfCar;
import com.example.introframework.factory.SportFactory;
import com.example.introframework.factory.SuvFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AppSpecificFramework {
    private static Map<CarFactory, FactoryOfCar<? extends Car>> map;

    static{
        map = new HashMap<>();
        map.put(CarFactory.SUV, new SuvFactory());
        map.put(CarFactory.SPORT, new SportFactory());
    }

    public void configure(AppSpecific appSpecific, CarFactory carFactory) throws IllegalAccessException {
        instanciate(appSpecific, carFactory);
    }

    private void instanciate(AppSpecific appSpecific, CarFactory carFactory) throws IllegalAccessException {
        Field[] declaredFields = appSpecific.getClass().getDeclaredFields();
        for (Field f : declaredFields){
            if (f.isAnnotationPresent(CarFactories.class)){
                f.setAccessible(true);
                CarFactories annotation = f.getAnnotation(CarFactories.class);
                CarFactory name = annotation.name();
                f.set(appSpecific, map.get(name));
            }
        }

    }


}
