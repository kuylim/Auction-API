/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.utilities;

import org.khmeracademy.btb.auc.pojo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Notification_service {
    private JavaMailSender javaMailSender;
    
    @Autowired
    public Notification_service(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }
    
    public void sendNotification() throws MailException
    {
        SimpleMailMessage mail = new SimpleMailMessage();
        
        mail.setTo("kuylim.tith@gmail.com");
        mail.setFrom("kuylim.auction@gmail.com");
        mail.setSubject("Spring Boot Testing");
        mail.setText("Hello this is testing");
        
        javaMailSender.send(mail);
    }
}
