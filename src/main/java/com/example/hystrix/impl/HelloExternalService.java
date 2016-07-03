package com.example.hystrix.impl;

public class HelloExternalService {

    public String hello(String name){
        return "Hello, " + name + "!";
    }

}
