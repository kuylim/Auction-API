/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.btb.auc.pojo.entity.Bid_log;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Bid_log_repository {
     
    @Insert("Insert Into auc_bid_log (current_price, date, auc_id, usr_id) values (#{current_price}, #{date}, #{auc_id}, #{usr_id})")
    boolean add(Bid_log bid);
    
    @Select("SELECT \n" +
            "  Count(auc_bid_log.bid_id) as Number_Of_Bid, \n" +
            "  auc_bid_log.auc_id\n" +
            "FROM \n" +
            "  public.auc_bid_log\n" +
            "Group By auc_bid_log.auc_id")
    @Results({
        @Result(property = "number_of_bid", column = "Number_Of_Bid"),
        @Result(property = "auc_id", column = "auc_id")   
    })
    ArrayList<Bid_log> getNumberOfBid();
}

