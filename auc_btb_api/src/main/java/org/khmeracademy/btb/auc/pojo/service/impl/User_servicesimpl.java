/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.khmeracademy.btb.auc.pojo.repository.User_repository;
import org.khmeracademy.btb.auc.pojo.service.User_service;
import org.khmeracademy.btb.auc.pojo.utilities.VerifyCode_sevice;

/**
 *
 * @author User
 */
@Service
public class User_servicesimpl implements User_service{

    @Autowired
    private User_repository usr_repo;
    
    @Autowired
    private VerifyCode_sevice verifycode;
    
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
        String verifyKey = "" + UUID.randomUUID();
        user.setVerifyKey(verifyKey);
        verifycode.sendComfirmation(user);
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

    @Override
    public List<User> findAll(AuctionFilter filter, Pagination pagination) {
        return usr_repo.findAll(filter, pagination);
    }

    @Override
    public int count(AuctionFilter filter) {
        return usr_repo.count(filter);
    }

    @Override
    public User comfirmEmail(String key) {
        return usr_repo.comfirmEmail(key);
    }

    @Override
    public boolean activateAccount(int id) {
        return usr_repo.activateAccount(id);
    }
    
}
