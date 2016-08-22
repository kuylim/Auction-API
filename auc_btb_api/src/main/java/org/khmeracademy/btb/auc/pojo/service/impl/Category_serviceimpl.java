/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.Category;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.repository.Category_repository;
import org.khmeracademy.btb.auc.pojo.service.Category_service;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Category_serviceimpl implements Category_service{
    @Autowired
    private Category_repository cate_repo;

    @Override
    public ArrayList<Category> getCategories() {
        return cate_repo.getCategories();
    }

    @Override
    public boolean remove(int id) {
        return cate_repo.remove(id);
    }

    @Override
    public boolean save(Category category) {
        return cate_repo.add(category);
    }

    @Override
    public boolean update(Category category) {
        return cate_repo.update(category);
    }

    @Override
    public Category search(int id) {
        return cate_repo.search(id);
    }

    @Override
    public List<Category> findAll(AuctionFilter filter, Pagination pagination) {
       // cate_repo.count(filter);
        return cate_repo.findAll(filter, pagination);
    }

    @Override
    public int count(AuctionFilter filter) {
        return cate_repo.count(filter);
    }
}
