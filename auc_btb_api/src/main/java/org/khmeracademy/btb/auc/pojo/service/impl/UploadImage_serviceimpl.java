/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
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
            String THUMBNAIL_PATH = "/opt/project/thumnail/";
			
            java.io.File path = new java.io.File(UPLOAD_PATH);
            java.io.File thum_path = new java.io.File(THUMBNAIL_PATH);
            if(!path.exists())
                path.mkdirs();
            if (!thum_path.exists()) {
		thum_path.mkdirs();
            }
			
            List<String> names = new ArrayList<>();
            for(MultipartFile file: files)
            {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                    try 
                    {
                        byte[] bytes = file.getBytes();
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName)); //copy path name to server
                        try {
                                //TODO: USING THUMBNAILS TO RESIZE THE IMAGE
                                
				Thumbnails.of(UPLOAD_PATH + "/" + fileName)
				.forceSize(500, 800)
				.toFiles(thum_path, Rename.NO_CHANGE);
				} catch (Exception ex) {
                                   BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(THUMBNAIL_PATH +  fileName)));
                                   stream.write(bytes);
                                    stream.close();
				}
			names.add(fileName); // add file name
                        imRepo.upload(pro_service.getLatest().getPro_id(), fileName); // upload path to database
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
