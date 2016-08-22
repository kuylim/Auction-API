/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Brand;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.repository.Brand_repository;
import org.khmeracademy.btb.auc.pojo.service.Brand_service;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Brand_serviceimpl implements Brand_service{

    @Autowired
    private Brand_repository brand_repo;
    
    @Override
    public ArrayList<Brand> getProductBrand() {
        return brand_repo.getProductBrands();
    }

    @Override
    public boolean remove(int id) {
        return brand_repo.remove(id);
    }

    @Override
    public boolean save(Brand brand) {
        return brand_repo.add(brand);
    }

    @Override
    public boolean update(Brand brand) {
        return brand_repo.update(brand);
    }

    @Override
    public Brand search(int id) {
        return brand_repo.search(id);
    }

    @Override
    public ArrayList<Brand> getNumberOfAuctionInBrand() {
        return brand_repo.getNumberOfAuctionInBrand();
    }

    @Override
    public List<Brand> findAll(AuctionFilter filter, Pagination pagination) {
        return brand_repo.findAll(filter, pagination);
    }

    @Override
    public int count(AuctionFilter filter) {
        return brand_repo.count(filter);
    }
    
}
