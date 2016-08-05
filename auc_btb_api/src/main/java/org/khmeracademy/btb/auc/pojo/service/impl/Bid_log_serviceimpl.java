/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Bid_log;
import org.khmeracademy.btb.auc.pojo.repository.Bid_log_repository;
import org.khmeracademy.btb.auc.pojo.service.Bid_log_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class Bid_log_serviceimpl implements Bid_log_service{

    @Autowired
    private Bid_log_repository bid_log_repo;
    
    @Override
    public ArrayList<Bid_log> getNumberOfBid() {
        return bid_log_repo.getNumberOfBid();
    }

    @Override
    public boolean save(Bid_log bid_log) {
        return bid_log_repo.add(bid_log);
    }    
}
