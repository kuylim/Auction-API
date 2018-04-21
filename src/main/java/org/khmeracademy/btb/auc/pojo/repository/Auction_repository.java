/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.Auction_history;
import org.khmeracademy.btb.auc.pojo.entity.Image;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Auction_repository {

    @Select("SELECT \n"
            + "  auc_auction.product_condition, \n"
            + "  auc_auction.start_price, \n"
            + "  auc_auction.buy_price, \n"
            + "  auc_auction.current_price, \n"
            + "  auc_auction.bid_increment_price, \n"
            + "  auc_auction.start_date, \n"
            + "  auc_auction.end_date, \n"
            + "  auc_product.name, \n"
            + "  auc_product.pro_info, \n"
            + "  auc_product_owner.firstname, \n"
            + "  auc_product_owner.lastname, \n"
            + "  auc_product_owner.phone, \n"
            + "  auc_product_owner.email, \n"
            + "  auc_product_owner.address, \n"
            + "  auc_product_owner.company_profile, \n"
            + "  auc_product_owner.owner_id, \n"
            + "  auc_product.pro_id, \n"
            + "(SELECT COUNT(auc_bid_log.bid_id) as Number_of_bids FROM auc_bid_log WHERE auc_bid_log.auc_id = auc_auction.auc_id),   \n"
            + "  auc_auction.auc_id\n"
            + "FROM auc_auction\n"
            + "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n"
            + "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n"
            + "WHERE  auc_auction.status = 'true'\n"
            + "offset #{offset} limit #{limit}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    ArrayList<Auction_Detail> getAuctions(Pagination pagination);

    //delete
    @Update("Update auc_auction Set status = 'false' WHERE auc_id=#{id}")
    boolean remove(int id);

    @Insert("Insert Into auc_auction "
            + "(product_condition, "
            + "start_price, "
            + "buy_price, "
            + "bid_increment_price, "
            + "current_price, "
            + "start_date, "
            + "end_date, "
            + "status, "
            + "owner_id, "
            + "usr_id, "
            + "pro_id) "
            + "values (#{product_condition}, "
            + "#{start_price}, "
            + "#{buy_price}, "
            + "#{bid_increment_price}, "
            + "#{current_price}, "
            + "#{start_date}, "
            + "#{end_date}, "
            + "'true', "
            + "#{owner_id}, "
            + "#{usr_id}, "
            + "#{pro_id})")
    boolean add(Auction auction);

    @Update("Update auc_auction Set product_condition=#{product_condition}, "
            + "start_price=#{start_price}, "
            + "buy_price=#{buy_price}, "
            + "bid_increment_price=#{bid_increment_price}, "
            + "current_price=#{current_price}, "
            + "start_date=#{start_date}, "
            + "end_date=#{end_date}, "
            + "owner_id=#{owner_id}, "
            + "usr_id=#{usr_id}, "
            + "pro_id=#{pro_id}   where auc_id = #{auc_id}")
    boolean update(Auction auction);

    @Select("SELECT \n"
            + "  auc_auction.product_condition, \n"
            + "  auc_auction.start_price, \n"
            + "  auc_auction.buy_price, \n"
            + "  auc_auction.current_price, \n"
            + "  auc_auction.bid_increment_price, \n"
            + "  auc_auction.start_date, \n"
            + "  auc_auction.end_date, \n"
            + "  auc_product.name, \n"
            + "  auc_product.pro_info, \n"
            + "  auc_product_owner.firstname, \n"
            + "  auc_product_owner.lastname, \n"
            + "  auc_product_owner.phone, \n"
            + "  auc_product_owner.email, \n"
            + "  auc_product_owner.address, \n"
            + "  auc_product_owner.company_profile, \n"
            + "  Count(auc_bid_log.bid_id) as Number_of_bids, \n"
            + "  auc_product.pro_id, \n"
            + "  auc_auction.auc_id\n"
            + "FROM auc_auction\n"
            + "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n"
            + "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id \n"
            + "LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id \n"
            + "WHERE  auc_auction.status = 'true' \n"
            + "AND auc_auction.auc_id = #{id} "
            + "Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages"))

    })
    Auction_Detail search(int id);

    @Update("Update auc_auction Set current_price=#{current_price} WHERE auc_id=#{id}")
    boolean update_currentprice(@Param("current_price") double current_price, @Param("id") int id);

    @Select("SELECT COUNT(auc_auction.auc_id)\n" +
             "FROM auc_auction\n" +
             "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n" +
             "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n" +
            "WHERE  auc_auction.status = 'true'\n")
    int countAuction();
    
    @Select("SELECT COUNT(auc_id) FROM auc_auction Where status = 'false'")
    int countDisableAuction();

    @Select("SELECT COUNT(auc_auction.auc_id) FROM auc_auction\n"
            + "INNER JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n"
            + "WHERE  auc_auction.status = 'true' \n"
            + "AND auc_product.cat_id = #{id} "
    )
    int countAuctionByCategory(int id);

    @Select("SELECT \n"
            + "  auc_auction.product_condition, \n"
            + "  auc_auction.start_price, \n"
            + "  auc_auction.buy_price, \n"
            + "  auc_auction.current_price, \n"
            + "  auc_auction.bid_increment_price, \n"
            + "  auc_auction.start_date, \n"
            + "  auc_auction.end_date, \n"
            + "  auc_product.name, \n"
            + "  auc_product.pro_info, \n"
            + "  auc_product_owner.firstname, \n"
            + "  auc_product_owner.lastname, \n"
            + "  auc_product_owner.phone, \n"
            + "  auc_product_owner.email, \n"
            + "  auc_product_owner.address, \n"
            + "  auc_product_owner.company_profile, \n"
            + "  auc_product_owner.owner_id, \n"
            + "  auc_product.pro_id, \n"
            + "  Count(auc_bid_log.bid_id) as Number_of_bids, \n"
            + "  auc_auction.auc_id\n"
            + "FROM auc_auction\n"
            + "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n"
            + "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n"
            + "LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id\n"
            + "WHERE  auc_auction.status = 'true'\n"
            + "AND auc_product.cat_id = #{id}\n"
            + "Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id "
            + "offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    ArrayList<Auction_Detail> getAuctionsByCategory(@Param("pagination") Pagination pagination, @Param("id") int id);

    @Select("SELECT  \n"
            + " auc_auction.product_condition,  \n"
            + " auc_auction.start_price,  \n"
            + " auc_auction.buy_price,  \n"
            + " auc_auction.current_price,  \n"
            + " auc_auction.bid_increment_price,  \n"
            + " auc_auction.start_date,  \n"
            + " auc_auction.end_date,  \n"
            + " auc_product.name,  \n"
            + " auc_product.pro_info,  \n"
            + " auc_product_owner.firstname,  \n"
            + " auc_product_owner.lastname,  \n"
            + " auc_product_owner.phone,  \n"
            + " auc_product_owner.email,  \n"
            + " auc_product_owner.address,  \n"
            + " auc_product_owner.company_profile,  \n"
            + " auc_product_owner.owner_id,  \n"
            + " auc_product.pro_id,  \n"
            + " Count(auc_bid_log.bid_id) as Number_of_bids,  \n"
            + " auc_auction.auc_id \n"
            + " FROM auc_auction \n"
            + " \n"
            + " LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n"
            + " LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id \n"
            + " LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id \n"
            + " \n"
            + " WHERE  auc_auction.status = 'true' \n"
            + " AND auc_product.brand_id = #{id}\n"
            + " Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id \n"
            + " offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    ArrayList<Auction_Detail> getAuctionsByBrand(@Param("pagination") Pagination pagination, @Param("id") int id);

    @Select("SELECT COUNT(auc_auction.auc_id) FROM auc_auction\n"
            + "INNER JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n"
            + "WHERE  auc_auction.status = 'true' \n"
            + "AND auc_product.brand_id = #{id} "
    )
    int countAuctionByBrand(int id);
    
    @Select("SELECT \n" +
        "  auc_product.name, \n" +
        "  auc_product.pro_info, \n" +
        "  auc_auction.product_condition, \n" +
        "  auc_auction.start_price, \n" +
        "  auc_auction.buy_price, \n" +
        "  auc_auction.bid_increment_price, \n" +
        "  auc_bid_log.current_price, \n" +
        "  auc_auction.start_date, \n" +
        "  auc_auction.end_date, \n" +
        "  auc_auction.status, \n" +
        "  auc_product_owner.firstname AS owner_firstname, \n" +
        "  auc_product_owner.lastname AS owner_lastname, \n" +
        "  auc_product_owner.phone AS owner_phone, \n" +
        "  auc_product_owner.email AS owner_email, \n" +
        "  auc_product_owner.address AS owner_address, \n" +
        "  auc_product_owner.company_profile, \n" +
        "  auc_user.firstname AS user_firstname, \n" +
        "  auc_user.lastname AS user_lastname, \n" +
        "  auc_user.phone AS user_phone, \n" +
        "  auc_user.email AS user_email, \n" +
        "  auc_user.address AS user_address, \n" +
        "  auc_bid_log.date, \n" +
        "  auc_auction.auc_id, \n" +
        "  auc_user.usr_id, \n" +
        "  auc_product_owner.owner_id, \n" +
        "  auc_product.pro_id,\n" +
        "  auc_bid_log.auc_id AS bid_id\n" +
        "FROM \n" +
        "  public.auc_auction, \n" +
        "  public.auc_bid_log, \n" +
        "  public.auc_product, \n" +
        "  public.auc_product_owner, \n" +
        "  public.auc_user\n" +
        "WHERE \n" +
        "  auc_auction.auc_id = auc_bid_log.auc_id AND\n" +
        "  auc_product.pro_id = auc_auction.pro_id AND\n" +
        "  auc_product_owner.owner_id = auc_auction.owner_id AND\n" +
        "  auc_user.usr_id = auc_bid_log.usr_id AND\n" +
        "  auc_auction.status = 'true' AND\n" +
        "  auc_user.usr_id = #{id}"
        + " offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "pro_name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "pro_condition", column = "product_condition"),
        @Result(property = "auc_start_price", column = "start_price"),
        @Result(property = "auc_buy_price", column = "buy_price"),
        @Result(property = "auc_bid_increment", column = "bid_increment_price"),
        @Result(property = "auc_current_price", column = "current_price"),
        @Result(property = "auc_start_date", column = "start_date"),
        @Result(property = "auc_end_date", column = "end_date"),
        @Result(property = "auc_status", column = "status"),
        @Result(property = "owner_firstname", column = "owner_firstname"),
        @Result(property = "owner_lastname", column = "owner_lastname"),
        @Result(property = "owner_phone", column = "owner_phone"),
        @Result(property = "owner_email", column = "owner_email"),
        @Result(property = "owner_address", column = "owner_address"),
        @Result(property = "owner_com_profile", column = "company_profile"),
        @Result(property = "user_firstname", column = "user_firstname"),
        @Result(property = "user_lastname", column = "user_lastname"),
        @Result(property = "user_phone", column = "user_phone"),
        @Result(property = "user_email", column = "user_email"),
        @Result(property = "user_address", column = "user_address"),
        @Result(property = "bid_date", column = "date"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "bid_log_id", column = "bid_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    public ArrayList<Auction_history> getAuctionHistoryByUser(@Param("pagination") Pagination pagination, @Param("id") int id);
    
    @Select("SELECT \n"
            + "  count(auc_bid_log.auc_id)\n"
            + "FROM \n"
            + "  public.auc_auction, \n"
            + "  public.auc_bid_log\n"
            + "WHERE \n"
            + "  auc_auction.auc_id = auc_bid_log.auc_id AND\n"
            + "  auc_auction.status = 'true' AND\n"
            + "  auc_bid_log.usr_id = #{id} ")
    public int countAuctionHistoryByUser(int id);
    
    
    @Select("SELECT  \n"
            + "          auc_product.name,  \n"
            + "          auc_product.pro_info,  \n"
            + "          auc_auction.product_condition,  \n"
            + "          auc_auction.start_price,  \n"
            + "          auc_auction.buy_price,  \n"
            + "          auc_auction.bid_increment_price,  \n"
            + "          auc_bid_log.current_price,  \n"
            + "          auc_auction.start_date,  \n"
            + "          auc_auction.end_date,  \n"
            + "          auc_auction.status,  \n"
            + "          auc_product_owner.firstname AS owner_firstname,  \n"
            + "          auc_product_owner.lastname AS owner_lastname,  \n"
            + "          auc_product_owner.phone AS owner_phone,  \n"
            + "          auc_product_owner.email AS owner_email,  \n"
            + "          auc_product_owner.address AS owner_address,  \n"
            + "          auc_product_owner.company_profile,  \n"
            + "          auc_user.firstname AS user_firstname,  \n"
            + "          auc_user.lastname AS user_lastname,  \n"
            + "          auc_user.phone AS user_phone,  \n"
            + "          auc_user.email AS user_email,  \n"
            + "          auc_user.address AS user_address,  \n"
            + "          auc_bid_log.date,  \n"
            + "          auc_auction.auc_id,  \n"
            + "          auc_user.usr_id,  \n"
            + "          auc_product_owner.owner_id,  \n"
            + "          auc_product.pro_id, \n"
            + "          auc_bid_log.auc_id AS bid_id \n"
            + "        FROM  \n"
            + "          public.auc_auction\n"
            + "          LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n"
            + "          LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n"
            + "          LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id\n"
            + "          LEFT JOIN auc_user ON auc_user.usr_id = auc_bid_log.usr_id  \n"
            + "          WHERE auc_auction.status = 'true' AND \n"
            + "          auc_auction.auc_id = #{id}"
            + " offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "pro_name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "pro_condition", column = "product_condition"),
        @Result(property = "auc_start_price", column = "start_price"),
        @Result(property = "auc_buy_price", column = "buy_price"),
        @Result(property = "auc_bid_increment", column = "bid_increment_price"),
        @Result(property = "auc_current_price", column = "current_price"),
        @Result(property = "auc_start_date", column = "start_date"),
        @Result(property = "auc_end_date", column = "end_date"),
        @Result(property = "auc_status", column = "status"),
        @Result(property = "owner_firstname", column = "owner_firstname"),
        @Result(property = "owner_lastname", column = "owner_lastname"),
        @Result(property = "owner_phone", column = "owner_phone"),
        @Result(property = "owner_email", column = "owner_email"),
        @Result(property = "owner_address", column = "owner_address"),
        @Result(property = "owner_com_profile", column = "company_profile"),
        @Result(property = "user_firstname", column = "user_firstname"),
        @Result(property = "user_lastname", column = "user_lastname"),
        @Result(property = "user_phone", column = "user_phone"),
        @Result(property = "user_email", column = "user_email"),
        @Result(property = "user_address", column = "user_address"),
        @Result(property = "bid_date", column = "date"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "bid_log_id", column = "bid_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    public ArrayList<Auction_history> getAuctionHistoryByAdmin(@Param("pagination") Pagination pagination, @Param("id") int id);
    
    @Select("SELECT \n" +
 "  count(auc_bid_log.auc_id)\n"
            + "FROM \n"
            + "  public.auc_auction, \n"
            + "  public.auc_bid_log\n"
            + "WHERE \n"
            + "  auc_auction.auc_id = auc_bid_log.auc_id AND\n"
            + "  auc_auction.status = 'true' AND\n"
            + "  auc_auction.auc_id = #{id}")
    public int countAuctionHistoryByAdmin(int id);
    
    @Select("SELECT \n" +
        "   auc_auction.product_condition, \n" +
        "   auc_auction.start_price, \n" +
        "   auc_auction.buy_price, \n" +
        "   auc_auction.current_price, \n" +
        "   auc_auction.bid_increment_price, \n" +
        "   auc_auction.start_date, \n" +
        "   auc_auction.end_date, \n" +
        "   auc_product.name, \n" +
        "   auc_product.pro_info, \n" +
        "   auc_product_owner.firstname, \n" +
        "   auc_product_owner.lastname, \n" +
        "   auc_product_owner.phone, \n" +
        "   auc_product_owner.email, \n" +
        "   auc_product_owner.address, \n" +
        "   auc_product_owner.company_profile, \n" +
        "   Count(auc_bid_log.bid_id) as Number_of_bids, \n" +
        "   auc_product.pro_id, \n" +
        "   auc_auction.auc_id\n" +
        "   FROM auc_auction\n" +
        "   LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n" +
        "   LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id \n" +
        "   LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id \n" +
        "   WHERE  auc_auction.status = 'true' \n" +
        "   AND auc_product.name ~* #{pro_name}\n" +
        "   Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id\n"
            + "offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages"))

    })
    public ArrayList<Auction_Detail> searchAuctionByProductName(@Param("pagination") Pagination pagination, @Param("pro_name") String pro_name);
    
    @Select("SELECT COUNT(auc_auction.auc_id) FROM auc_auction " +
            "   LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id \n" +
            "   LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id \n" +
            "   LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id \n" +
            "   WHERE  auc_auction.status = 'true' \n" +
            "   AND auc_product.name ~* #{pro_name}")
    int countAuctionByProductName(String pro_name);
    
    @Select("SELECT \n" +
        "   auc_auction.product_condition, \n" +
        "   auc_auction.start_price, \n" +
        "   auc_auction.buy_price, \n" +
        "   auc_auction.current_price, \n" +
        "   auc_auction.bid_increment_price, \n" +
        "   auc_auction.start_date, \n" +
        "   auc_auction.end_date, \n" +
        "   auc_product.name, \n" +
        "   auc_product.pro_info, \n" +
        "   auc_product_owner.firstname, \n" +
        "   auc_product_owner.lastname, \n" +
        "   auc_product_owner.phone, \n" +
        "   auc_product_owner.email, \n" +
        "   auc_product_owner.address, \n" +
        "   auc_product_owner.company_profile, \n" +
        "   auc_product_owner.owner_id, \n" +
        "   auc_product.pro_id, \n" +
        "   Count(auc_bid_log.bid_id) as Number_of_bids, \n" +
        "   auc_auction.auc_id\n" +
        "   FROM auc_auction\n" +
        "   LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n" +
        "   LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n" +
        "   LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id\n" +
        "   WHERE  auc_auction.status = 'true'\n" +
        "   Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id \n" +
        "   Order By start_date DESC \n" +
        "   LIMIT 8")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    ArrayList<Auction_Detail> getNewAuction();
    
    @Select("SELECT \n" +
        "   auc_auction.start_date, \n" +
        "   auc_auction.end_date, \n" +
        "   auc_product.name,  \n" +
        "   Count(auc_bid_log.bid_id) as Number_of_bids, \n" +
        "   auc_auction.auc_id\n" +
        "   FROM auc_auction\n" +
        "   LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n" +
        "   LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n" +
        "   LEFT JOIN auc_bid_log ON auc_auction.auc_id = auc_bid_log.auc_id\n" +
        "   WHERE  auc_auction.status = 'true'\n" +
        "   Group By auc_product.pro_id,auc_auction.auc_id,auc_product_owner.owner_id \n" +
        "   ORDER BY Number_of_bids DESC")
    @Results({    
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "name", column = "name"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id")
    })  
    ArrayList<Auction_Detail> getTopAndLowAuction();
    
    
    @Select("SELECT \n"
            + "  auc_auction.product_condition, \n"
            + "  auc_auction.start_price, \n"
            + "  auc_auction.buy_price, \n"
            + "  auc_auction.current_price, \n"
            + "  auc_auction.bid_increment_price, \n"
            + "  auc_auction.start_date, \n"
            + "  auc_auction.end_date, \n"
            + "  auc_product.name, \n"
            + "  auc_product.pro_info, \n"
            + "  auc_product_owner.firstname, \n"
            + "  auc_product_owner.lastname, \n"
            + "  auc_product_owner.phone, \n"
            + "  auc_product_owner.email, \n"
            + "  auc_product_owner.address, \n"
            + "  auc_product_owner.company_profile, \n"
            + "  auc_product_owner.owner_id, \n"
            + "  auc_product.pro_id, \n"
            + "(SELECT COUNT(auc_bid_log.bid_id) as Number_of_bids FROM auc_bid_log WHERE auc_bid_log.auc_id = auc_auction.auc_id),   \n"
            + "  auc_auction.auc_id\n"
            + "FROM auc_auction\n"
            + "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n"
            + "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n"
            + "WHERE  auc_auction.status = 'true'\n"
            + "AND auc_product.name ~* #{filter.name} "
            + "AND auc_product.cat_id::TEXT LIKE '%' || #{filter.categoryId} || '%' \n " 
            + "offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "product_condition", column = "product_condition"),
        @Result(property = "start_price", column = "start_price"),
        @Result(property = "buy_price", column = "buy_price"),
        @Result(property = "current_price", column = "current_price"),
        @Result(property = "bid_increment_price", column = "bid_increment_price"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        @Result(property = "image", column = "image"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "Number_of_bids", column = "Number_of_bids"),
        @Result(property = "auc_id", column = "auc_id"),
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "images", column = "pro_id", many = @Many(select = "findImages")
        )
    })
    public List<Auction_Detail> findAll(@Param("filter")AuctionFilter filter, @Param("pagination")Pagination pagination);
    
    @Select("SELECT COUNT(auc_auction.auc_id) " 
            + "FROM auc_auction\n"
            + "LEFT JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id\n"
            + "LEFT JOIN auc_product_owner ON auc_product_owner.owner_id = auc_auction.owner_id\n"
            + "WHERE  auc_auction.status = 'true'\n"
            + "AND auc_product.name ~* #{filter.name} "
            + "AND auc_product.cat_id::TEXT LIKE '%' || #{filter.categoryId} || '%' \n  ")
    public int count(@Param("filter") AuctionFilter filter);
    
    
    @Select("SELECT img_path FROM auc_images WHERE pro_id = #{pro_id}")
    @Results(value = {
        @Result(property = "img_path", column = "img_path")
    })
    public ArrayList<Image> findImages(int pro_id);

}
