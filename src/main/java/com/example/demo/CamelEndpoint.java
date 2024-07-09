package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelEndpoint extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet");

        rest("/api")
                .get("/hello").to("direct:hello");

        from("direct:hello")
                .setBody(constant("Hello, World!"));
    }
}
