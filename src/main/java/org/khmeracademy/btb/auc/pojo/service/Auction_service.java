/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.Auction_history;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author User
 */
public interface Auction_service {
    ArrayList<Auction_Detail> getAuctions(Pagination pagination);
    boolean remove(int id);
    boolean save(Auction auction);
    boolean update(Auction auction);
    Auction_Detail search(int id);
    boolean update_currentprice(double current_price, int id);
    int countAuction();
    ArrayList<Auction_Detail> getAuctionsByCategory(Pagination pagination, int id);
    ArrayList<Auction_Detail> getAuctionsByBrand(Pagination pagination, int id);
    int countAuctionByCategory(int id);
    int countAuctionByBrand(int id);
    ArrayList<Auction_history> getAuctionHistoryByUser(Pagination pagination,int id);
    ArrayList<Auction_history> getAuctionHistoryByAdmin(Pagination pagination,int id);
    int countAuctionHistoryByUser(int id);
    int countAuctionHistoryByAdmin(int id);
    ArrayList<Auction_Detail> searchAuctionByProductName(Pagination pagination, String pro_name);
    int countAuctionByProductName(String pro_name);
    ArrayList<Auction_Detail> getNewAuction();
    int countDisableAuctions();
    ArrayList<Auction_Detail> getTopAndLowAuction();
    
    public List<Auction_Detail> findAll(AuctionFilter filter, Pagination pagination);
    int count(AuctionFilter filter);
}
