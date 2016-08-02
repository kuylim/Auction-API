/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
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
    @Select("Select * from tbluser")
    @Results({
        @Result(property = "id", column = "usrid"),
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "status", column = "status")
    })
    ArrayList<User> getUsers();
    
    @Delete("DELETE FROM tbluser WHERE usrid=#{id}")
    boolean remove(int id);
    
    @Insert("Insert Into tbluser (username, password, phone, email, status) values (#{username}, #{password}, #{phone}, #{email}, #{status})")
    boolean add(User user);
    
    @Update("Update tbluser Set username=#{username}, password=#{password}, phone=#{phone} where usrid = #{id}")
    boolean update (User user);
    
    @Select("Select * from tbluser where usrid = #{id}")
    @Results({
        @Result(property = "id", column = "usrid"),
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "status", column = "status")
    })
    User search(int id);
}
