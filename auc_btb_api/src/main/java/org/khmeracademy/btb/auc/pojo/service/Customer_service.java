/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Customer;

/**
 *
 * @author User
 */
public interface Customer_service {
    ArrayList<Customer> getCustomers();
    boolean remove(int id);
    boolean save(Customer customer);
    boolean update(Customer customer);
    Customer search(int id);
}
