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
import org.khmeracademy.btb.auc.pojo.entity.Product_Owner;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Product_owner_repository {
    @Select("Select * from auc_product_owner  Where status = 'true'")
    @Results({
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "status", column = "status")
    })
    ArrayList<Product_Owner> getProductOwner();
    
    // delete
    @Update("Update auc_product_owner Set status = 'false' WHERE owner_id=#{id}")
    boolean remove(int id);
    
    @Insert("Insert Into auc_product_owner (firstname, lastname, phone, email, address, company_profile, status) values (#{firstname}, #{lastname}, #{phone}, #{email}, #{address}, #{company_profile}, 'true')")
    boolean add(Product_Owner pro_owner);
    
    @Update("Update auc_product_owner Set firstname=#{firstname}, lastname=#{lastname}, phone=#{phone}, email = #{email}, address=#{address}, company_profile = #{company_profile} where owner_id = #{owner_id}")
    boolean update (Product_Owner pro_owner);
    
    @Select("Select * from auc_product_owner where owner_id = #{id}")
    @Results({
        @Result(property = "owner_id", column = "owner_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "company_profile", column = "company_profile"),
        @Result(property = "status", column = "status")
    })
    Product_Owner search(int id);
}
