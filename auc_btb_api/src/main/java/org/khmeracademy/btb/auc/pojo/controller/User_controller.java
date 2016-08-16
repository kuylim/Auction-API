/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.entity.UserLogin;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.khmeracademy.btb.auc.pojo.service.User_service;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/api/user")
public class User_controller {
     @Autowired
    private User_service usr_service;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUser(
            @RequestParam(value = "page", required = false , defaultValue="1") int page 
            , @RequestParam(value="limit" , required = false , defaultValue="12") int limit)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
            pagination.setLimit(limit);
            pagination.setPage(page);
            pagination.setTotalCount(usr_service.countUsers());
            ArrayList<User> user = usr_service.getUsers(pagination);
            
            if(!user.isEmpty())
            {
                map.put("DATA", user);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND!");
                map.put("PAGINATION", pagination);
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
            if(usr_service.remove(id)){
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

    
    @RequestMapping(value = "/add-user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add_user(@RequestBody User user)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(usr_service.save_user(user)){
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
    
    
    @RequestMapping(value = "/add-admin", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add_admin(@RequestBody User user)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(usr_service.save_admin(user)){
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
    public ResponseEntity<Map<String, Object>> edit(@RequestBody User customer)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(usr_service.update(customer)){
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
    public ResponseEntity<Map<String, Object>> search(@PathVariable("id") int id)
    {
         Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            User customer = usr_service.search(id);
            if(customer!=null)
            {
                map.put("DATA", customer);
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
    
    @RequestMapping(value = "/update-balance", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> updateBalance(@RequestBody User customer)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(usr_service.updateBalance(customer)){
		map.put("MESSAGE", "User balance has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "User balance has not been updated.");
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
    
    @RequestMapping(value="/find-user-by-email", method = RequestMethod.POST , produces = "application/json")
	public ResponseEntity<Map<String , Object>> findUserByEmail(@RequestBody UserLogin login){
		Map< String , Object> map = new HashMap<String , Object>();
		try{
                    map.put("STATUS",true);
                    map.put("MESSAGE","Success");
                    map.put("DATA", usr_service.findUserByEmail(login.getEmail()) );
                    System.out.println(map);
			
		}catch(Exception e){
			map.put("STATUS",false);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
        
//    @RequestMapping(value="/validate-email/{email}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//        public ResponseEntity<Map<String, Object>> validate_email (@PathVariable("email") String email)
//        {
//             Map<String, Object> map = new HashMap<String, Object>();
//            try
//            {
//                User customer = usr_service.findUserByEmail(email);
//                if(customer!=null)
//                {
//                    map.put("DATA", customer);
//                    map.put("STATUS", true);
//                    map.put("MESSAGE", "DATA FOUND!");
//                }
//                else
//                {
//                    map.put("STATUS", true);
//                    map.put("MESSAGE", "DATA NOT FOUND");
//                }
//            }
//            catch (Exception e)
//            {
//                map.put("STATUS", false);
//                map.put("MESSAGE", "Error!");
//                e.printStackTrace();
//            }
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//        }
  
    
}
