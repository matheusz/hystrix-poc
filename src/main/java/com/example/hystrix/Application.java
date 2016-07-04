package com.example.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.example.hystrix")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
