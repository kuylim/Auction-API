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
    @Select("Select * from auc_user  Where status = 'true'")
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
