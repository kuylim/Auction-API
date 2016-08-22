/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.Topup_log;
import org.khmeracademy.btb.auc.pojo.service.Topup_log_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUYLIM
 */
@RestController
@RequestMapping(value = "/api/user")
public class Topup_controller {
    
    @Autowired
    private Topup_log_service topup_service;
    
    @RequestMapping(value = "/add-topup-log", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add_topup_log(@RequestBody Topup_log topup)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(topup_service.add(topup)){
		map.put("MESSAGE", "User has been inserted.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Topup log has not been inserted.");
		map.put("STATUS", false);
            }
	}
        catch(Exception e){
            map.put("MESSAGE", "Error!");
            map.put("STATUS", false);
            e.printStackTrace();
	}
	return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
    }
}
