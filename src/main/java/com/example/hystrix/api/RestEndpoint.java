package com.example.hystrix.api;

import com.example.hystrix.impl.HelloExternalService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1")
public class RestEndpoint {

    @Autowired private HelloExternalService helloExternalService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name){
        return helloExternalService.hello(name);
    }

}
