package com.example.hystrix.client.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigModule {

    @Bean
    public JerseyConfig jerseyConfig(){
        return new JerseyConfig();
    }

}
