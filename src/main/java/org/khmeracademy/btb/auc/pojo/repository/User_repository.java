/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface User_repository {
    @Select("Select * from auc_user  Where status = 'true' AND role = 'ROLE_USER' offset #{offset} limit #{limit}")
    @Results({
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status")
        
    })
    ArrayList<User> getCustomers(Pagination paginatin);
    
    //delete
    @Update("Update auc_user Set status = 'false' WHERE usr_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_user (firstname, lastname, username, phone, email, address, credit, password, status, role, verifyKey) values (#{firstname}, #{lastname}, #{username}, #{phone}, #{email}, #{address}, 4000, #{password}, 'false', 'ROLE_USER', #{verifyKey})")
    boolean add_user(User customer);
    
    @Insert("Insert Into auc_user (firstname, lastname, username, phone, email, address, credit, password, status, role) values (#{firstname}, #{lastname}, #{username}, #{phone}, #{email}, #{address}, #{credit}, #{password}, 'true', 'ROLE_ADMIN')")
    boolean add_admin(User customer);
   
    @Update("Update auc_user Set firstname=#{firstname}, lastname=#{lastname}, username=#{username}, phone=#{phone}, email=#{email}, address = #{address}, credit = #{credit}, password = #{password}  where usr_id = #{usr_id}")
    boolean update (User customer);
    
    @Update("Update auc_user Set credit = #{credit} WHERE usr_id=#{usr_id}")
    boolean updateBalance(User customer);
    
    @Select("Select * from auc_user where usr_id = #{id}")
    @Results({
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status"),
        @Result(property = "verifyKey", column = "verifykey")
    })
    User search(int id);  
    
    @Select ("Select * from auc_user where verifykey = #{key}")
        @Results({
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status"),
        @Result(property = "verifyKey", column = "verifykey")
    })
    User comfirmEmail(String key);
    
    @Update("Update auc_user Set status='true'  where usr_id = #{id}")
    boolean activateAccount (int id);
    
    @Select("SELECT COUNT(usr_id) FROM auc_user Where status = 'true' AND role = 'ROLE_USER'")
    int countCustomer();
    
    @Select("SELECT usr_id, username, password, email, role FROM auc_user Where status = 'true' AND email = #{userEmail}")
	@Results(value = {
			@Result(property = "usr_id" , column = "usr_id"),
			@Result(property = "username" , column = "username"),
			@Result(property = "email" , column = "email"),
			@Result(property = "password" , column = "password"),
			@Result(property = "role" , column = "role")
        })
    User findUserByEmail(@Param("userEmail") String userEmail);
    
    @Select("Select * from auc_user  Where status = 'true' AND role = 'ROLE_USER'"
            + "AND firstname ~* #{filter.name}\n"
            + "offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status"),
        @Result(property = "verifyKey", column = "verifykey")
        
    })
    List<User> findAll(@Param("filter")AuctionFilter filter, @Param("pagination")Pagination pagination);
    
    @Select("Select Count(usr_id) from auc_user Where status = 'true' AND firstname ~* #{filter.name}")
    int count(@Param("filter") AuctionFilter filter);
    
    @Select("Select * from auc_user  Where status = 'true' AND role = 'ROLE_ADMIN'"
            + "AND firstname ~* #{filter.name}\n"
            + "offset #{pagination.offset} limit #{pagination.limit}")
    @Results({
        @Result(property = "usr_id", column = "usr_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status"),
        @Result(property = "verifyKey", column = "verifykey")
        
    })
    List<User> findAllAdmin(@Param("filter")AuctionFilter filter, @Param("pagination")Pagination pagination);
    
     @Select("Select Count(usr_id) from auc_user Where status = 'true' AND role = 'ROLE_ADMIN' AND firstname ~* #{filter.name}")
    int countAdmin(@Param("filter") AuctionFilter filter);
    
  
}
