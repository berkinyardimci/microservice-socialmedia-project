package com.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(MailServiceApplication.class);
    }

    private final JavaMailSender javaMailSender;

    public MailServiceApplication(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("berkinyardimci98@gmail.com");
        mailMessage.setTo("berkinyardimci98@gmail.com");
        mailMessage.setSubject("AKTİVASYON KODUNUZ....");
        mailMessage.setText("adıyla başarılı bir şekilde kayıt oldunuz\n"+"Aktivasyon kodunuz: 782AJJJ ");
        System.out.println("xxxxxx------");
        javaMailSender.send(mailMessage);
    }

}