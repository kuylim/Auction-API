/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;

/**
 *
 * @author User
 */
public interface User_service {
    ArrayList<User> getUsers(Pagination paginatin);
    boolean remove(int id);
    boolean updateBalance(User customer);
    boolean save_user(User user);
    boolean save_admin(User user);
    boolean update(User user);
    User search(int id);
    int countUsers();
    User findUserByEmail(String email);
    int countUser();
    
}
