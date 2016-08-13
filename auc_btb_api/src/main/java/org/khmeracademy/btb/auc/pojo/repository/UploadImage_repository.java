/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UploadImage_repository {
    @Insert("Insert Into auc_images (pro_id, img_path) values (#{pro_id}, #{img_path})")
    boolean upload(@Param("pro_id") int pro_id, @Param("img_path") String img_path);
}
