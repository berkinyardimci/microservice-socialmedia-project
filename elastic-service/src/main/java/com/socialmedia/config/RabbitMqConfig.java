package com.socialmedia.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${rabbitmq.queueregisterelastic}")
    private String elasticRegisterQueue;


    @Bean
    Queue registerQueueElastic(){
        return new Queue(elasticRegisterQueue);
    }
}
