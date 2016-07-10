package com.example.hystrix.server.api;

import com.example.hystrix.server.impl.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1")
public class RestEndpoint {

    @Autowired private RandomService randomService;

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public Double random(){
        return randomService.generateRandom();
    }

}
