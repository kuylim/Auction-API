/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.List;
import org.khmeracademy.btb.auc.pojo.entity.Product;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
public interface Product_service {
    ArrayList<Product> getProduct();
    boolean remove(int id);
    boolean save(Product pro, List<MultipartFile> files);
    boolean update(Product pro);
    Product search(int id);
    Product getLatest();
}
