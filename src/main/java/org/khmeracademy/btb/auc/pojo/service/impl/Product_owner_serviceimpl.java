/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Product_Owner;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.repository.Product_owner_repository;
import org.khmeracademy.btb.auc.pojo.service.Product_owner_service;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class Product_owner_serviceimpl implements Product_owner_service{

    @Autowired
    private Product_owner_repository Pro_owner_Repo;
    
    @Override
    public ArrayList<Product_Owner> get_Product_Owner() {
        return Pro_owner_Repo.getProductOwner();
    }

    @Override
    public boolean remove(int id) {
        return Pro_owner_Repo.remove(id);
    }

    @Override
    public boolean save(Product_Owner pro_owner) {
        return Pro_owner_Repo.add(pro_owner);
    }

    @Override
    public boolean update(Product_Owner pro_owner) {
        return Pro_owner_Repo.update(pro_owner);
    }

    @Override
    public Product_Owner search(int id) {
        return Pro_owner_Repo.search(id);
    }

    @Override
    public List<Product_Owner> findAll(AuctionFilter filter, Pagination pagination) {
        return Pro_owner_Repo.findAll(filter, pagination);
    }

    @Override
    public int count(AuctionFilter filter) {
        return Pro_owner_Repo.count(filter);
    }
    
}
