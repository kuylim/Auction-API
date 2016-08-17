/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Product;
import org.khmeracademy.btb.auc.pojo.repository.Product_repository;
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
public class Product_serviceimpl implements Product_service{

    @Autowired
    private Product_repository pro_repo;
    
    @Autowired
    UploadImage_service im_service;
    
    @Override
    public ArrayList<Product> getProduct() {
        return pro_repo.getProducts();
    }

    @Override
    public boolean remove(int id) {
        return pro_repo.remove(id);
    }

    @Override
    public boolean save(Product pro, List<MultipartFile> files) {
        
        pro_repo.add(pro);
        im_service.upload(pro.getPro_id(), files);
        
        return true;
    }

    @Override
    public boolean update(Product pro) {
        return pro_repo.update(pro);
    }

    @Override
    public Product search(int id) {
        return pro_repo.search(id);
    }

    @Override
    public Product getLatest() {
        return pro_repo.getLastest();
    }
    
}
