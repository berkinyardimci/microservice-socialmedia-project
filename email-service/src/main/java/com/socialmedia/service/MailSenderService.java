package com.socialmedia.service;

import com.socialmedia.rabbitmq.model.RegisterMailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;
    public void sendMail(RegisterMailModel model){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("berkinyardimci98@gmail.com");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("AKTİVASYON KODUNUZ....");
        mailMessage.setText(model.getUsername()+" adıyla başarılı bir şekilde kayıt oldunuz\n"+"Aktivasyon kodunuz: "+model.getActivationCode());
        javaMailSender.send(mailMessage);
    }
}
