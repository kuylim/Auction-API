/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.utilities;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Winner;
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
    
    public void sendNotification(ArrayList<Winner> winner) throws MailException
    {
        
        for(int i = 0 ; i < winner.size() ;i++)
        {
            SimpleMailMessage mail = new SimpleMailMessage();
        
            mail.setTo(winner.get(i).getCus_email());
            mail.setFrom("kuylim.auction@gmail.com");
            mail.setSubject("Win Auction");
            mail.setText("Dear,\n\n"
                         + winner.get(i).getCus_firstname() + "\n" 
                         + "\tCongratulation! You have win an" + winner.get(i).getPro_name() + ". Your auction code is : " + winner.get(i).getAuc_id() + "\n" 
                         + "Please come to check out your product at our office.\n\n"
                         + "Regard,\n\n"
                         + "Auction Team.");

            javaMailSender.send(mail);
        }  
    }
}
