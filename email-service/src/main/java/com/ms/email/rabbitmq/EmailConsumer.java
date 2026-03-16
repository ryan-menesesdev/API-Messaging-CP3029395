package com.ms.email.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "order.queue")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }
}
