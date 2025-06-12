package com.ejemplo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost/test.camel.queue?username=guest&password=guest")
            .log("Mensaje recibido: ${body}");
    }
}
