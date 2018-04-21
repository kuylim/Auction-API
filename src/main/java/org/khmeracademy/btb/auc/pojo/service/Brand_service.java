/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Brand;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author KUYLIM
 */
public interface Brand_service {
    ArrayList<Brand> getProductBrand();
    boolean remove(int id);
    boolean save(Brand brand);
    boolean update(Brand brand);
    Brand search(int id);
    ArrayList<Brand> getNumberOfAuctionInBrand();
    
    public List<Brand> findAll(AuctionFilter filter, Pagination pagination);
    int count(AuctionFilter filter);
}
