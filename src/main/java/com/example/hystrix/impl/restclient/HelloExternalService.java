package com.example.hystrix.impl.restclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class HelloExternalService {

    private RestTemplate restTemplate;

    public HelloExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String hello(String name){
        String random = restTemplate.getForObject("http://localhost:9000/hystrix/v1/random", String.class);
        return "Hello, " + name + "! Your random is " + random;
    }

    public String fallback(String name){
        return "Hello from fallback method!";
    }

}
