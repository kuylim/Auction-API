/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.utilities;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.khmeracademy.btb.auc.pojo.entity.User;
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
public class VerifyCode_sevice {
     private JavaMailSender javaMailSender;
    
    @Autowired
    public VerifyCode_sevice(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }
    
    public void sendComfirmation(User user) throws MailException, MessagingException
    {
        
            //javaMailSender.setHost("");
            //SimpleMailMessage mail = new SimpleMailMessage();
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(message, true);
            
            mail.setFrom("kuylim.auction@gmail.com");
            mail.setTo(user.getEmail());
//            
            mail.setSubject("Verify Email");
//            mail.setText("Dear,\n\n"
//                         + user.getFirstname() 
//                         + "\tCongratulation! You have register to K-Auction. Click on this link to activate your account  \n" 
//                         + "\t\t<a href ='http://localhost:2222/verifykey/"+user.getVerifyKey()+"'> link </a>"
//                         + "If this is not you just ignore this email.\n\n"
//                         + "Regard,\n\n"
//                         + "Auction Team.");

            mail.setText("<html>"
                            + "<body>"
                                    +"<p>Dear, " + user.getFirstname() + "</p>"
                                    +"<p>Congratulation! You have register to K-Auction. Click <a href='http://localhost:2222/verifykey/" + user.getVerifyKey() +"'>here</a>"
                                    +" to activate your account.</p>"
                                    +"<p>If this is not you. please ignore this email.</p>"
                                    +"<br/>"
                                    +"<p>Regard,</p>"
                                    +"<p>K-Auction Team.</p>"
                            + "</body>"
                        + "</html>", true);
            javaMailSender.send(message);
    }
}
