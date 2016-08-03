/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Brand;

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
}
