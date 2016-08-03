/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.Category;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.service.Category_service;
import org.khmeracademy.btb.auc.pojo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUYLIM
 */
@RestController
@RequestMapping(value = "/api/category")
public class Category_controller {
    @Autowired
    private Category_service cate_service;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getCategories()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            ArrayList<Category> cate = cate_service.getCategories();
            if(!cate.isEmpty())
            {
                map.put("DATA", cate);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND!");
            }
            else
            {
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA NOT FOUND");
            }
        }
        catch (Exception e)
        {
            map.put("STATUS", false);
            map.put("MESSAGE", "Error!");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") int id)
    {
        Map<String, Object> map = new HashMap<String , Object>();
        try{
            if(cate_service.remove(id)){
		map.put("MESSAGE", "User has been deleted");
		map.put("STATUS", true);
            }
            else
            {
		map.put("MESSAGE", "User has not been deleted");
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

    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add(@RequestBody Category cate)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(cate_service.save(cate)){
		map.put("MESSAGE", "User has been inserted.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "User has not been inserted.");
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
    
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
//    public void edit(@RequestBody User stu)
//    {
//        usrService.update(stu);    
//    }
    public ResponseEntity<Map<String, Object>> edit(@RequestBody Category cate)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(cate_service.update(cate)){
		map.put("MESSAGE", "User has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "User has not been updated.");
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
    
    @RequestMapping(value="/search/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
//    public User search(@PathVariable("id") int id){
//	User user = usrService.search(id);
//	return user;
//    }
    public ResponseEntity<Map<String, Object>> search(@PathVariable("id") int id)
    {
         Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Category cate = cate_service.search(id);
            if(cate!=null)
            {
                map.put("DATA", cate);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND!");
            }
            else
            {
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA NOT FOUND");
            }
        }
        catch (Exception e)
        {
            map.put("STATUS", false);
            map.put("MESSAGE", "Error!");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
