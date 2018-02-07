package com.lukasz.feederservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FeederServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeederServiceApplication.class, args);
    }
}
