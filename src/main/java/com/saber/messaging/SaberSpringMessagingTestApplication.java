package com.saber.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SaberSpringMessagingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaberSpringMessagingTestApplication.class, args);
    }

    @Bean
    CommandLineRunner simple(@Value("${spring.amqp.exchange}") String exchange,
                             @Value("${spring.amqp.queue}") String rotingKey,
                             Producer producer) {
        return args -> {
            producer.sendMessage(exchange, rotingKey, "Hello Saber Lee 66");
        };
    }

}
