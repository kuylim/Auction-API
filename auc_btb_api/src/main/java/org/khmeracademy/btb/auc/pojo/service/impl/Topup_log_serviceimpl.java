/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service.impl;

import org.khmeracademy.btb.auc.pojo.entity.Topup_log;
import org.khmeracademy.btb.auc.pojo.repository.Topup_log_repository;
import org.khmeracademy.btb.auc.pojo.service.Topup_log_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUYLIM
 */
@Service
public class Topup_log_serviceimpl implements Topup_log_service{
    @Autowired
    private Topup_log_repository topup_repo;

    @Override
    public boolean add(Topup_log topup) {
        return topup_repo.add(topup);
    }
}
