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
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Auction_repository {
    @Select("SELECT \n" +
        "  auc_auction.product_condition, \n" +
        "  auc_auction.start_price, \n" +
        "  auc_auction.buy_price, \n" +
        "  auc_auction.current_price, \n" +
        "  auc_auction.start_date, \n" +
        "  auc_auction.end_date, \n" +
        "  auc_auction.auc_id, \n" +
        "  auc_product.image, \n" +
        "  auc_product.name\n" +
        "FROM \n" +
        "  public.auc_auction, \n" +
        "  public.auc_product\n" +
        "WHERE \n" +
        "  auc_product.pro_id = auc_auction.pro_id AND\n" +
        "  auc_auction.status = 'true'")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name")
    })
    ArrayList<Auction> getAuctions();
    
    //delete
    @Update("Update auc_auction Set status = 'false' WHERE auc_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_auction (product_condition, start_price, buy_price, bid_increment_price, current_price, start_date, end_date, status, owner_id, usr_id, pro_id) values (#{product_condition}, #{start_price}, #{buy_price}, #{bid_increment_price}, #{current_price}, #{start_date}, #{end_date}, 'true', #{owner_id}, #{usr_id}, #{pro_id})")
    boolean add(Auction auction);
    
   
    //@Update("Update auc_user Set username=#{username}, password=#{password}, phone=#{phone}, email=#{email} where usr_id = #{id}")
    boolean update (Auction auction);
    
    @Select("SELECT \n" +
            "  auc_auction.product_condition, \n" +
            "  auc_auction.start_price, \n" +
            "  auc_auction.buy_price, \n" +
            "  auc_auction.current_price, \n" +
            "  auc_auction.start_date, \n" +
            "  auc_auction.end_date, \n" +
            "  auc_product.name, \n" +
            "  auc_product.pro_info, \n" +
            "  auc_product.image, \n" +
            "  auc_product_owner.firstname, \n" +
            "  auc_product_owner.lastname, \n" +
            "  auc_product_owner.phone, \n" +
            "  auc_product_owner.email, \n" +
            "  auc_product_owner.address, \n" +
            "  auc_product_owner.company_profile, \n" +
            "  auc_auction.auc_id, \n" +
            "  auc_product.pro_id, \n" +
            "  auc_product_owner.owner_id\n" +
            "FROM \n" +
            "  public.auc_auction, \n" +
            "  public.auc_product, \n" +
            "  public.auc_product_owner\n" +
            "WHERE \n" +
            "  auc_product.pro_id = auc_auction.pro_id AND\n" +
            "  auc_product_owner.owner_id = auc_auction.owner_id AND\n" +
            "  auc_auction.status = 'true' AND\n" +
            "  auc_auction.auc_id = #{id}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "image", column = "image"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "owner_id", column = "owner_id")
    })
    Auction_Detail search(int id);
}
