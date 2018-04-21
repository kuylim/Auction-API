///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.khmeracademy.btb.auc.pojo.controller;
//
//import org.khmeracademy.btb.auc.pojo.utilities.Notification_service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author KUYLIM
// */
//@RestController
//public class Sendmail_controller {
//    
//    @Autowired
//    private Notification_service notification;
//    
//    @RequestMapping("/done")
//    public String success()
//    {
//        try
//        {
//            notification.sendNotification();
//        }
//        catch(MailException e)
//        {
//            
//        }
//        return "sign-up success";
//    }
//}
