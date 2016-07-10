package com.example.hystrix.server.impl.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public RandomService randomService(){
        return new RandomService();
    }

}
