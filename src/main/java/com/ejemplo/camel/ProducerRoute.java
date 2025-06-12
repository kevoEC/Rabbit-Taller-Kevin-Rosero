package com.ejemplo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:generate?period=5000")
            .setBody().simple("Mensaje generado en ${date:now:yyyy-MM-dd HH:mm:ss}")
            .log("Enviando: ${body}")
            .to("rabbitmq://localhost/test.camel.queue?username=guest&password=guest");
    }
}
