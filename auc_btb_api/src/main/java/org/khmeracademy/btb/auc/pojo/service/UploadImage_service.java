/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Image;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author User
 */
public interface UploadImage_service {
    public Image upload(int pro_id ,List<MultipartFile> files);
}
