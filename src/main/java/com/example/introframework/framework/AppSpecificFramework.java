package com.example.introframework.framework;

import com.example.introframework.annotation.CarTag;
import com.example.introframework.entity.CarType;
import com.example.introframework.entity.Car;
import com.example.introframework.factory.FactoryOfCar;
import com.example.introframework.factory.SportFactory;
import com.example.introframework.factory.SuvFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AppSpecificFramework {
    private static Map<CarType, FactoryOfCar<? extends Car>> map;

    static{
        map = new HashMap<>();
        map.put(CarType.SUV, new SuvFactory());
        map.put(CarType.SPORT, new SportFactory());
    }

    public void configure(AppSpecific appSpecific,CarStrategy strategy, CarType carFactory) throws IllegalAccessException {
        instanciate(appSpecific, strategy, carFactory);
    }

    private void instanciate(AppSpecific appSpecific, CarStrategy strategy, CarType carType) throws IllegalAccessException {
        Field[] declaredFields = appSpecific.getClass().getDeclaredFields();
        for (Field f : declaredFields){
            if (f.isAnnotationPresent(CarTag.class)){
                f.setAccessible(true);
                Class<?> innerClass = f.get(appSpecific).getClass();
                Field[] innerFields = innerClass.getDeclaredFields();
                for (Field innerField : innerFields){
                    if (innerField.isAnnotationPresent(CarTag.class)){
                        innerField.setAccessible(true);
                        innerField.set(strategy, map.get(carType));
                    }
                }
            }
        }
    }

}
