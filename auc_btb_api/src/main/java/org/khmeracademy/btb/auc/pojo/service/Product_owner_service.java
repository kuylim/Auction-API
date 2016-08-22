/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Product_Owner;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author User
 */
public interface Product_owner_service {
    ArrayList<Product_Owner> get_Product_Owner();
    boolean remove(int id);
    boolean save(Product_Owner pro_owner);
    boolean update(Product_Owner pro_owner);
    Product_Owner search(int id);
    
    public List<Product_Owner> findAll(AuctionFilter filter, Pagination pagination);
    int count(AuctionFilter filter);
}
