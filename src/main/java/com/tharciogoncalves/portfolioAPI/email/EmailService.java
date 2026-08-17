package com.tharciogoncalves.portfolioAPI.email;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendEmail(EmailDTO email){
        var message = new SimpleMailMessage();

        message.setReplyTo(email.emailFrom());
        message.setFrom(email.emailFrom());
        message.setTo(email.emailTo());
        message.setSubject(email.subject());
        message.setText("Por " + email.name() + ": " + email.message());

        this.mailSender.send(message);
    }
}
