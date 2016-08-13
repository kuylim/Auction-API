/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Product;

/**
 *
 * @author User
 */
public interface Product_service {
    ArrayList<Product> getProduct();
    boolean remove(int id);
    boolean save(Product pro);
    boolean update(Product pro);
    Product search(int id);
    Product getLatest();
}
