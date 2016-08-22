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
import org.apache.ibatis.annotations.SelectKey;
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
        @Result(property = "brand_id", column = "brand_id")
    })
    ArrayList<Product> getProducts();
    
    //delete
    @Update("Update auc_product Set status = 'false' WHERE pro_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_product (name, pro_info, status, cat_id, brand_id) values (#{name}, #{pro_info}, 'true', #{cat_id}, #{brand_id})")
    @SelectKey(keyProperty = "pro_id", keyColumn = "pro_id", before = false, resultType =int.class, statement = "SELECT last_value FROM tblproduct_proid_seq")
    int add(Product pro);
    
   
    @Update("Update auc_product Set name=#{name}, pro_info=#{pro_info}, cat_id=#{cat_id}, brand_id=#{brand_id} where pro_id = #{pro_id}")
    boolean update (Product pro);
    
    @Select("Select * from auc_product where pro_id = #{id}")
    @Results({
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "status", column = "status"),
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "brand_id", column = "brand_id")
    })
    Product search(int id);
    
    @Select("Select * from auc_product  Where status = 'true' Order By pro_id DESC LIMIT 1")
    @Results({
        @Result(property = "pro_id", column = "pro_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "pro_info", column = "pro_info"),
        @Result(property = "status", column = "status"),
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "brand_id", column = "brand_id")
    })
    Product getLastest();
    
    @Select("SELECT \n" +
        "  Count(auc_product.pro_id) \n" +
        "FROM \n" +
        "  public.auc_product\n" +
        "  Where auc_product.status = 'true'")
    int countProduct();
}
