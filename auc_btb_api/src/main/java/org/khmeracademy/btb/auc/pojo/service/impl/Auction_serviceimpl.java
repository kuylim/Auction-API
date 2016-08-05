/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.repository.Auction_repository;
import org.khmeracademy.btb.auc.pojo.service.Auction_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class Auction_serviceimpl implements Auction_service{

     @Autowired
    private Auction_repository auc_repo;
    
    @Override
    public ArrayList<Auction_Detail> getAuctions() {
        return auc_repo.getAuctions();
    }

    @Override
    public boolean remove(int id) {
        return auc_repo.remove(id);
    }

    @Override
    public boolean save(Auction auction) {
        return auc_repo.add(auction);
    }

    @Override
    public boolean update(Auction auction) {
        return auc_repo.update(auction);
    }

    @Override
    public Auction_Detail search(int id) {
        return auc_repo.search(id);
    }
    
}
