package com.socialmedia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;
    public void sendMail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("berkinyardimci98@gmail.com");
        mailMessage.setTo("berkinyardimci98@gmail.com");
        mailMessage.setSubject("AKTİVASYON KODUNUZ....");
        mailMessage.setText("adıyla başarılı bir şekilde kayıt oldunuz\n"+"Aktivasyon kodunuz: 782AJJJ ");

        javaMailSender.send(mailMessage);
    }
}
