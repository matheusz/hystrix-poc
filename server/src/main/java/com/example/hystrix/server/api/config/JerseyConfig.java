package com.example.hystrix.server.api.config;

import com.example.hystrix.server.api.RestEndpoint;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RestEndpoint.class);
    }

}
