package com.saber.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String exchange,String routingKey,String message){
        System.out.println("Send Message=====> "+routingKey);
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
