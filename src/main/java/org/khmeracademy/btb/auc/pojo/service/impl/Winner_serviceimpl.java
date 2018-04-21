/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import org.khmeracademy.btb.auc.pojo.entity.Winner;
import org.khmeracademy.btb.auc.pojo.repository.Winner_repository;
import org.khmeracademy.btb.auc.pojo.service.Winner_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class Winner_serviceimpl implements Winner_service{

    @Autowired
    private Winner_repository winnerRepo;

    @Override
    public ArrayList<Winner> getWinner(Date end_date) {
        return winnerRepo.getWinner(end_date);
    }
    

    
}
