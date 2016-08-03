/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Product;
import org.khmeracademy.btb.auc.pojo.repository.Product_repository;
import org.khmeracademy.btb.auc.pojo.service.Product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class Product_serviceimpl implements Product_service{

    @Autowired
    private Product_repository pro_repo;
    
    @Override
    public ArrayList<Product> getProduct() {
        return pro_repo.getProducts();
    }

    @Override
    public boolean remove(int id) {
        return pro_repo.remove(id);
    }

    @Override
    public boolean save(Product pro) {
        return pro_repo.add(pro);
    }

    @Override
    public boolean update(Product pro) {
        return pro_repo.update(pro);
    }

    @Override
    public Product search(int id) {
        return pro_repo.search(id);
    }
    
}
