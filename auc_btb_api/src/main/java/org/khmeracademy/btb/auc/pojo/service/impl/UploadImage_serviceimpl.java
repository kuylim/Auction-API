/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.khmeracademy.btb.auc.pojo.entity.Image;
import org.khmeracademy.btb.auc.pojo.repository.UploadImage_repository;
import org.khmeracademy.btb.auc.pojo.service.Product_service;
import org.khmeracademy.btb.auc.pojo.service.UploadImage_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@Service
public class UploadImage_serviceimpl implements UploadImage_service{

    @Autowired
    private UploadImage_repository imRepo;
    
    @Autowired
    private Product_service pro_service;
    
    @Override
    public Image upload(List<MultipartFile> files, String folder) {
        Image uploadImage = new Image();
        if(files.isEmpty()){
	
	}
        else
        {
			
            if(folder=="" || folder==null)
				folder = "default";
            String UPLOAD_PATH = "/opt/project/" + folder;
			
            java.io.File path = new java.io.File(UPLOAD_PATH);
            if(!path.exists())
                path.mkdirs();
			
		List<String> names = new ArrayList<>();
		for(MultipartFile file: files)
                {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                    try 
                    {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName)); //copy path name to server
			names.add(fileName); // add file name
                        imRepo.upload(pro_service.getLatest().getPro_id(), fileName);
                    } 
                    catch (Exception e) { 
			
                    }
		}
                uploadImage.setProjectPath("/resources/" + folder);
		uploadImage.setServerPath(UPLOAD_PATH);
		uploadImage.setNames(names);
		uploadImage.setMessage("File has been uploaded successfully!!!");
		}
		return uploadImage;
    }
    
}
