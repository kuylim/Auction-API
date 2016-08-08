/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Customer;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author User
 */
public interface Customer_service {
    ArrayList<Customer> getCustomers(Pagination paginatin);
    boolean remove(int id);
    boolean updateBalance(Customer customer);
    boolean save(Customer customer);
    boolean update(Customer customer);
    Customer search(int id);
    int countCustomer();
}
