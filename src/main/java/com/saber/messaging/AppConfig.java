package com.saber.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${spring.amqp.queue}")
    private String queue;
    @Value("${spring.amqp.exchange}")
    private String exchange;
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(exchange,true,false);
    }

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange());
    }
}
