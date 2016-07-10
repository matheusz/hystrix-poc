package com.example.hystrix.client.impl.restclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HelloExternalService {

    private RestTemplate restTemplate;

    public HelloExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20")
    }, fallbackMethod = "fallback")
    public List<String> hello(String name, Integer numberOfRequests) {
        return IntStream.range(0, numberOfRequests)
                .mapToObj(getRandomNumberFromExternalService())
                .map(makeRandomHelloMessage(name))
                .collect(Collectors.toList());
    }

    private Function<Double, String> makeRandomHelloMessage(String name) {
        return random -> "Hello, " + name + "! Your random is " + random;
    }

    private IntFunction<Double> getRandomNumberFromExternalService() {
        return index -> restTemplate.getForObject("http://localhost:9001/api/v1/random", Double.class);
    }

    public List<String> fallback(String name, Integer numberOfRequests){
        return Arrays.asList("Hello from fallback method!");
    }

}
