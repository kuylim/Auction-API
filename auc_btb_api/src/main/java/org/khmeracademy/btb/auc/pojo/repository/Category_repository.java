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
import org.khmeracademy.btb.auc.pojo.entity.Category;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUYLIM
 */
@Repository
public interface Category_repository {
    @Select("Select * from auc_category  Where status = 'true'")
    @Results({
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "parent_id", column = "parent_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "status", column = "status")   
    })
    ArrayList<Category> getCategories();
    
    //delete
    @Update("Update auc_category Set status = 'false' WHERE cat_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_category (parent_id ,name, description, status) values (#{parent_id}, #{name}, #{description}, 'true')")
    boolean add(Category category);
    
   
    @Update("Update auc_category Set parent_id=#{parent_id}, name=#{name}, description=#{description} where cat_id = #{cat_id}")
    boolean update (Category category);
    
    @Select("Select * from auc_category where cat_id = #{id}")
    @Results({
        @Result(property = "cat_id", column = "cat_id"),
        @Result(property = "parent_id", column = "parent_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "status", column = "status")  
    })
    Category search(int id);
}
