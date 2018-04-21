/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import java.util.Date;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.btb.auc.pojo.entity.Winner;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUYLIM
 */
@Repository
public interface Winner_repository {
    @Select("SELECT \n" +
        "  auc_user.firstname AS cus_firstname, \n" +
        "  auc_user.lastname AS cus_lastname, \n" +
        "  auc_user.phone AS cus_phone, \n" +
        "  auc_user.email AS cus_email, \n" +
        "  auc_user.address AS cus_address, \n" +
        "  auc_product_owner.firstname AS owner_firstname, \n" +
        "  auc_product_owner.lastname AS owner_lastname, \n" +
        "  auc_product_owner.phone AS owner_phone, \n" +
        "  auc_product_owner.email AS owner_email, \n" +
        "  auc_product_owner.address AS owner_address, \n" +
        "  auc_auction.end_date, \n" +
        "  auc_auction.status, \n" +
        "  auc_auction.current_price, \n" +
        "  auc_bid_log.bid_id, \n" +
        "  auc_user.usr_id,\n" +
        "  auc_product.name AS pro_name, \n" +
        "  auc_auction.auc_id \n" +
        "FROM \n" +
        "  public.auc_auction, \n" +
        "  public.auc_bid_log, \n" +
        "  public.auc_user, \n" +
        "  public.auc_product_owner,\n" +
        "  auc_product\n" +
        "WHERE \n" +
        "  auc_auction.auc_id = auc_bid_log.auc_id AND\n" +
        "  auc_user.usr_id = auc_bid_log.usr_id AND\n" +
        "  auc_product_owner.owner_id = auc_auction.owner_id AND \n" +
        "  auc_auction.current_price = auc_bid_log.current_price AND \n" +
        "  auc_product.pro_id = auc_auction.pro_id AND \n" +
        "  auc_auction.end_date = #{end_date} AND \n" +
        "  auc_auction.status = 'true' ")
    @Results({
        @Result(property = "cus_firstname", column = "cus_firstname"),
        @Result(property = "cus_lastname", column = "cus_lastname"),
        @Result(property = "cus_phone", column = "cus_phone"),
        @Result(property = "cus_email", column = "cus_email"),
        @Result(property = "cus_address", column = "cus_address"),
        @Result(property = "owner_firstname", column = "owner_firstname"),
        @Result(property = "owner_lastname", column = "owner_lastname"),
        @Result(property = "owner_phone", column = "owner_phone"),
        @Result(property = "owner_email", column = "owner_email"),
        @Result(property = "owner_address", column = "owner_address"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "status", column = "status"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_id", column = "bid_id"),
        @Result(property = "cus_id", column = "usr_id"),
        @Result(property = "pro_name", column = "pro_name"),
        @Result(property = "auc_id", column = "auc_id")   
        
    })
    ArrayList<Winner> getWinner(Date end_date);
}
