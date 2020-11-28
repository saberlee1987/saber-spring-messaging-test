package com.saber.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "${spring.amqp.queue}")
    public void receiveMessage(String message){
        System.out.println(String.format("Receive Message ====> %s", message));
    }
}
