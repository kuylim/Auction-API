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
import org.khmeracademy.btb.auc.pojo.entity.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Product_repository {
    @Select("Select * from auc_product  Where status = 'true'")
    @Results({
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "status", column = "status"),
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "image", column = "image")
    })
    ArrayList<Product> getProducts();
    
    //delete
    @Update("Update auc_product Set status = 'false' WHERE pro_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_product (name, pro_info, status, cat_id, brand_id, image) values (#{name}, #{pro_info}, 'true', #{cat_id}, #{brand_id})")
    boolean add(Product pro);
    
   
    @Update("Update auc_product Set name=#{name}, pro_info=#{pro_info}, cat_id=#{cat_id}, brand_id=#{brand_id}, image=#{image} where pro_id = #{pro_id}")
    boolean update (Product pro);
    
    @Select("Select * from auc_product where pro_id = #{id}")
    @Results({
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "status", column = "status"),
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "image", column = "image")
    })
    Product search(int id);
}
