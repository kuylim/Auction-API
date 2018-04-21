///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.khmeracademy.btb.auc.pojo.controller;
//
//import java.util.List;
//import org.khmeracademy.btb.auc.pojo.entity.Image;
//import org.khmeracademy.btb.auc.pojo.service.UploadImage_service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author KUYLIM
// */
//@RestController
//@RequestMapping(value="/api/image")
//public class Image_upload_controller {
//    
//    @Autowired
//    UploadImage_service im_service;
//    
//    @RequestMapping(value="/upload", method = RequestMethod.POST)
//    public Image upload(@RequestParam("files") List<MultipartFile> files, 
//	@RequestParam(value="folder", required=false) String folder){
//	return im_service.upload(files, folder);
//    }
//}
