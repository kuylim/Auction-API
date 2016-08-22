/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.khmeracademy.btb.auc.pojo.repository.User_repository;
import org.khmeracademy.btb.auc.pojo.service.User_service;

/**
 *
 * @author User
 */
@Service
public class User_servicesimpl implements User_service{

    @Autowired
    private User_repository usr_repo;
    
    @Override
    public ArrayList<User> getUsers(Pagination paginatin) {
        return usr_repo.getCustomers(paginatin);
    }

    @Override
    public boolean remove(int id) {
        return usr_repo.remove(id);
    }

    @Override
    public boolean save_user(User user) {
        return usr_repo.add_user(user);
    }

    @Override
    public boolean update(User user) {
        return usr_repo.update(user);
    }

    @Override
    public User search(int id) {
        return usr_repo.search(id);
    }

    @Override
    public boolean updateBalance(User user) {
        return usr_repo.updateBalance(user);
    }

    @Override
    public int countUsers() {
        return usr_repo.countCustomer();
    }

    @Override
    public User findUserByEmail(String email) {
        return usr_repo.findUserByEmail(email);
    }

    @Override
    public boolean save_admin(User user) {
        return usr_repo.add_admin(user);
    }

    @Override
    public int countUser() {
        return usr_repo.countCustomer();
    }
    
}
