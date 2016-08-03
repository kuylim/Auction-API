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
import org.springframework.stereotype.Repository;
import org.khmeracademy.btb.auc.pojo.entity.User;

/**
 *
 * @author KUYLIM
 */
@Repository
public interface userRepository {
    @Select("Select * from auc_user  Where status = 'true'")
    @Results({
        @Result(property = "id", column = "usr_id"),
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "status", column = "status")
    })
    ArrayList<User> getUsers();
    
    //delete
    @Update("Update auc_user Set status = 'false' WHERE usr_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_user (username, password, phone, email, status) values (#{username}, #{password}, #{phone}, #{email}, 'true')")
    boolean add(User user);
    
   
    @Update("Update auc_user Set username=#{username}, password=#{password}, phone=#{phone}, email=#{email} where usr_id = #{id}")
    boolean update (User user);
    
    @Select("Select * from auc_user where usr_id = #{id}")
    @Results({
        @Result(property = "id", column = "usr_id"),
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "status", column = "status")
    })
    User search(int id);
}
