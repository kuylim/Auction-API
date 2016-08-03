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
import org.khmeracademy.btb.auc.pojo.entity.Brand;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUYLIM
 */
@Repository
public interface Brand_repository {
    @Select("Select * from auc_brand  Where status = 'true'")
    @Results({
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "status", column = "status")
    })
    ArrayList<Brand> getProductBrands();
    
    //delete
    @Update("Update auc_brand Set status = 'false' WHERE brand_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_brand (name, description, status) values (#{name}, #{description}, 'true')")
    boolean add(Brand brand);
    
   
    @Update("Update auc_brand Set name=#{name}, description=#{description} where brand_id = #{brand_id}")
    boolean update (Brand brand);
    
    @Select("Select * from auc_brand where brand_id = #{id}")
    @Results({
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "status", column = "status")
    })
    Brand search(int id);
}
