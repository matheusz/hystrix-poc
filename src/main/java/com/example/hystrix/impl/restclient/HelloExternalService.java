package com.example.hystrix.impl.restclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.client.RestTemplate;

public class HelloExternalService {

    private RestTemplate restTemplate;

    public HelloExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5")
    }, fallbackMethod = "fallback")
    public String hello(String name) {
        String random = restTemplate.getForObject("http://localhost:9000/api/v1/random", String.class);
        return "Hello, " + name + "! Your random is " + random;
    }

    public String fallback(String name){
        return "Hello from fallback method!";
    }

}
