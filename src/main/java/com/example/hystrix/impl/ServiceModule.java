package com.example.hystrix.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public HelloExternalService helloExternalService(){
        return new HelloExternalService();
    }

}
