package com.socialmedia.rabbitmq.producer;

import com.socialmedia.rabbitmq.model.RegisterElasticModel;
import com.socialmedia.rabbitmq.model.RegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {
    //kuyruga veri ekliyoruz producer da

    @Value("${rabbitmq.exchange-user}")
    private String directExchange;
    @Value("${rabbitmq.elasticregisterkey}")
    private String registerBindingKey;

    private final RabbitTemplate rabbitTemplate;

    public void  sendNewUser(RegisterElasticModel model){
        rabbitTemplate.convertAndSend(directExchange,registerBindingKey,model);
    }
}
