/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.btb.auc.pojo.entity.Top_Bidder;

/**
 *
 * @author User
 */
public interface Top_Bidder_repository {
    @Select("SELECT \n" +
        "  auc_user.firstname, \n" +
        "  auc_user.lastname, \n" +
        "  auc_user.username, \n" +
        "  auc_user.phone, \n" +
        "  auc_user.email, \n" +
        "  auc_user.address, \n" +
        "  Count (auc_bid_log.usr_id) as Number_of_bids\n" +
        "FROM \n" +
        "  public.auc_bid_log, \n" +
        "  public.auc_user\n" +
        "WHERE \n" +
        "  auc_user.usr_id = auc_bid_log.usr_id AND\n" +
        "  auc_user.status = 'true'\n" +
        "Group By auc_user.usr_id\n" +
        "Order By Number_of_bids DESC\n" +
        "LiMIT 5")
    @Results({
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "number_of_bid", column = "Number_of_bids")
    })
    ArrayList<Top_Bidder> getTop_bidder ();
}
