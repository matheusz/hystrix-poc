package com.example.hystrix.client.api;

import com.example.hystrix.client.impl.restclient.HelloExternalService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1")
public class RestEndpoint {

    @Autowired private HelloExternalService helloExternalService;

    @GET
    @Path("/hello/{numberOfRequests}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hello(@PathParam("numberOfRequests") Integer numberOfRequests,
                              @QueryParam("name") String name){
        return helloExternalService.hello(name, numberOfRequests);
    }

}
