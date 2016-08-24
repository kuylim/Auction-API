/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.utilities;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.khmeracademy.btb.auc.pojo.entity.User_feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Feedback_service {
    private JavaMailSender javaMailSender;
    
    @Autowired
    public Feedback_service(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }
    
    public boolean sendFeedback(User_feedback user) throws MailException, MessagingException
    {
        
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(message, true);
            
            mail.setTo("kuylim.auction@gmail.com");
            mail.setFrom("kuylim.auction@gmail.com");
            mail.setSubject(user.getSubject());
            
            mail.setText("<html>"
                            + "<body>"
                                    +"<p>Dear, K-Auction</p>"
                                    +"<p>"+user.getComment()+"</p>" 
                                    +"<p>Regard,</p>"
                                    +"<p>"+user.getName()+"</p>"
                                    +"<p> phone: "+ user.getPhone() + " email: " + user.getEmail() +"</p>"
                            + "</body>"
                        + "</html>", true);

            javaMailSender.send(message);
            return true;
    }
}
