/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.service;

import java.util.ArrayList;
import java.util.Date;
import org.khmeracademy.btb.auc.pojo.entity.Winner;

/**
 *
 * @author User
 */
public interface Winner_service {
     ArrayList<Winner> getWinner(Date end_date);
}
