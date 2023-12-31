package com.socialmedia.rabbitmq.consumer;

import com.socialmedia.rabbitmq.model.RegisterMailModel;
import com.socialmedia.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterMailConsumer {

    private final MailSenderService mailSenderService;
    @RabbitListener(queues = "${rabbitmq.registermailqueue}")
    public void sendActivationCode(RegisterMailModel model){
        log.info("Model {}",model.toString());
        mailSenderService.sendMail(model);
    }
}
