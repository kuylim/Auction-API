/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.khmeracademy.btb.auc.pojo.entity.Winner;
import org.khmeracademy.btb.auc.pojo.service.Auction_service;
import org.khmeracademy.btb.auc.pojo.service.Winner_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class Schedule_Task {
    
    @Autowired
    private Notification_service notification;
    
    @Autowired
    private Auction_service auc_service;
    
    @Autowired
    private Winner_service winner_service;
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Scheduled(fixedRate = 1000) // start task every 30minute to select winner
    public void sendMailToCustomers() {
        
        ArrayList<Winner> winner = null;
        try {
            winner = winner_service.getWinner(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException ex) {
            Logger.getLogger(Schedule_Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(winner.size());
        for(int i = 0 ; i< winner.size() ;i++)
        {
            auc_service.remove(winner.get(i).getAuc_id());
        }
        notification.sendNotification(winner);
        System.out.println("sendMailToCustomers Job ran at " 
            + dateFormat.format(new Date()));

    }
}
