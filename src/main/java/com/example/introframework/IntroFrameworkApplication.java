package com.example.introframework;

import com.example.introframework.annotation.CarFactory;
import com.example.introframework.entity.Suv;
import com.example.introframework.framework.AppSpecific;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroFrameworkApplication {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(IntroFrameworkApplication.class, args);

        AppSpecific appSpecific = new AppSpecific();
        appSpecific.configure(CarFactory.SUV);

        Suv suv = appSpecific.getSuv(1L, "Audi", "Q8");
        System.out.println(suv.getBrand() + " " + suv.getModel());
    }

}
