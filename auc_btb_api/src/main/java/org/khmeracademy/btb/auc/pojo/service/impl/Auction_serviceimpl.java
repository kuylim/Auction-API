/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.Auction_history;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.repository.Auction_repository;
import org.khmeracademy.btb.auc.pojo.service.Auction_service;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.x509.X500Name;

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

    @Override
    public ArrayList<Auction_history> getAuctionHistoryByUser(Pagination pagination,int id) {
        return auc_repo.getAuctionHistoryByUser(pagination,id);
    }

    @Override
    public ArrayList<Auction_history> getAuctionHistoryByAdmin(Pagination pagination,int id) {
        return auc_repo.getAuctionHistoryByAdmin(pagination,id);
    }

    @Override
    public int countAuctionHistoryByUser(int id) {
        return auc_repo.countAuctionHistoryByUser(id);
    }

    @Override
    public int countAuctionHistoryByAdmin(int id) {
        return auc_repo.countAuctionHistoryByAdmin(id);
    }

    @Override
    public ArrayList<Auction_Detail> searchAuctionByProductName(Pagination pagination, String pro_name) {
        return auc_repo.searchAuctionByProductName(pagination, pro_name);
    }

    @Override
    public int countAuctionByProductName(String pro_name) {
        return auc_repo.countAuctionByProductName(pro_name);
    }

    @Override
    public ArrayList<Auction_Detail> getNewAuction() {
        return auc_repo.getNewAuction();
    }

    @Override
    public int countDisableAuctions() {
        return auc_repo.countDisableAuction();
    }

    @Override
    public ArrayList<Auction_Detail> getTopAndLowAuction() {
        return auc_repo.getTopAndLowAuction();
    }

    @Override
    public List<Auction_Detail> findAll(AuctionFilter filter, Pagination pagination) {
        System.out.println("request" + filter.getName() + " " + filter.getCategoryId());
        pagination.setTotalCount(auc_repo.count(filter));
       return auc_repo.findAll(filter, pagination);
    }
    
}
