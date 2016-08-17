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
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
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
    public ArrayList<Auction_Detail> getAuctions(Pagination pagination) {
        return auc_repo.getAuctions(pagination);
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

    @Override
    public boolean update_currentprice(double current_price, int id) {
        return auc_repo.update_currentprice(current_price, id);
    }

    @Override
    public int countAuction() {
        return auc_repo.countAuction();
    }

    @Override
    public ArrayList<Auction_Detail> getAuctionsByCategory(Pagination pagination, int id) {
        return auc_repo.getAuctionsByCategory(pagination, id);
    }

    @Override
    public int countAuctionByCategory(int id) {
        return auc_repo.countAuctionByCategory(id);
    }

    @Override
    public ArrayList<Auction_Detail> getAuctionsByBrand(Pagination pagination, int id) {
        return auc_repo.getAuctionsByBrand(pagination, id);
    }

    @Override
    public int countAuctionByBrand(int id) {
        return auc_repo.countAuctionByBrand(id);
    }
    
}
