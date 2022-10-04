package com.example.introframework;

import com.example.introframework.annotation.CarType;
import com.example.introframework.entity.Car;
import com.example.introframework.framework.AppSpecific;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroFrameworkApplication {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(IntroFrameworkApplication.class, args);

        AppSpecific appSpecific = new AppSpecific();

        Car suv = appSpecific.getCar(CarType.SUV, 1L, "Audi", "Q8");
        System.out.println(suv.getBrand() + " " + suv.getModel());
    }

}
