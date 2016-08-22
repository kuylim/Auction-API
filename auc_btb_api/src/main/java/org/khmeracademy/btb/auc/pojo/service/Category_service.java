/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.btb.auc.pojo.entity.Category;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author KUYLIM
 */
public interface Category_service {
    ArrayList<Category> getCategories();
    boolean remove(int id);
    boolean save(Category category);
    boolean update(Category category);
    Category search(int id);
    
    public List<Category> findAll(AuctionFilter filter, Pagination pagination);
    int count(AuctionFilter filter);
}
