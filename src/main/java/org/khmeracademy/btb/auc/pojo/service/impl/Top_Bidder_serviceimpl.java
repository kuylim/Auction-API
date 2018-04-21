/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Top_Bidder;
import org.khmeracademy.btb.auc.pojo.repository.Top_Bidder_repository;
import org.khmeracademy.btb.auc.pojo.service.Top_Bidder_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Top_Bidder_serviceimpl implements Top_Bidder_service{
    
    @Autowired
    Top_Bidder_repository top_bidder;

    @Override
    public ArrayList<Top_Bidder> getTop_Bidder() {
        return top_bidder.getTop_bidder();
    }
}
