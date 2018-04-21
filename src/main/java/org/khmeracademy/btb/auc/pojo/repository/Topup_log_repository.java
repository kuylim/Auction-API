/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.repository;

import org.apache.ibatis.annotations.Insert;
import org.khmeracademy.btb.auc.pojo.entity.Topup_log;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUYLIM
 */
@Repository
public interface Topup_log_repository {
    
    
    @Insert("Insert Into auc_topup_log (amount, date, cus_id) values (#{amount}, #{date}, #{cus_id})")
    boolean add(Topup_log topup);
    
}
