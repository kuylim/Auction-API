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
    boolean update(Brand brand);

    @Select("Select * from auc_brand where brand_id = #{id}")
    @Results({
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "status", column = "status")
    })
    Brand search(int id);

    @Select("SELECT \n"
            + "auc_brand.name,\n"
            + "auc_brand.brand_id,\n"
            + "COUNT(auc_auction.auc_id) as number_of_brand\n"
            + "\n"
            + "FROM auc_auction\n"
            + "            INNER JOIN auc_product ON auc_product.pro_id = auc_auction.pro_id  \n"
            + "            INNER JOIN auc_brand ON auc_product.brand_id = auc_brand.brand_id\n"
            + "            WHERE  auc_auction.status = 'true'  \n"
            + "            \n"
            + "GROUP BY auc_brand.brand_id")
    @Results({
        @Result(property = "brand_id", column = "brand_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "number_of_brand", column = "number_of_brand")
    })
    ArrayList<Brand> getNumberOfAuctionInBrand();

}
