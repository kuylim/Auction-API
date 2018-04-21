/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import org.khmeracademy.btb.auc.pojo.entity.Bid_log;

/**
 *
 * @author User
 */
public interface Bid_log_service {
    ArrayList<Bid_log> getNumberOfBid();
    boolean save(Bid_log bid_log);
}
