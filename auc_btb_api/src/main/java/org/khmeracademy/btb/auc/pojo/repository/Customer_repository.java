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
import org.khmeracademy.btb.auc.pojo.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Customer_repository {
    @Select("Select * from auc_customer  Where status = 'true'")
    @Results({
        @Result(property = "cus_id", column = "cus_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status")
        
    })
    ArrayList<Customer> getCustomers();
    
    //delete
    @Update("Update auc_customer Set status = 'false' WHERE cus_id=#{id}")
    boolean remove(int id);
    
    
    @Insert("Insert Into auc_customer (firstname, lastname, username, phone, email, address, credit, password, status) values (#{firstname}, #{lastname}, #{username}, #{phone}, #{email}, #{address}, #{credit}, #{password}, 'true')")
    boolean add(Customer customer);
    
   
    @Update("Update auc_customer Set firstname=#{firstname}, lastname=#{lastname}, username=#{username}, phone=#{phone}, email=#{email}, address = #{address}, credit = #{credit}, password = #{password}  where cus_id = #{cus_id}")
    boolean update (Customer customer);
    
    @Select("Select * from auc_customer where cus_id = #{id}")
    @Results({
        @Result(property = "cus_id", column = "cus_id"),
        @Result(property = "firstname", column = "firstname"),
        @Result(property = "lastname", column = "lastname"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "credit", column = "credit"),
        @Result(property = "status", column = "status")
    })
    Customer search(int id);  
}
