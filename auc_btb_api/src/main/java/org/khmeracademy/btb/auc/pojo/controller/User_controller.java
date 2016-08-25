/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.entity.UserLogin;
import org.khmeracademy.btb.auc.pojo.entity.User_feedback;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
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
import org.khmeracademy.btb.auc.pojo.utilities.Feedback_service;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/api/user")
public class User_controller {
    @Autowired
    private User_service usr_service;
    
    @Autowired
    private Feedback_service feedback;
    
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
    
    @RequestMapping(value="/get-number-of-user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getNumberofUser()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            
            int numberOfUser = usr_service.countUser();
            
            if(numberOfUser!=0)
            {
                map.put("DATA", numberOfUser);
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
        
    @RequestMapping(value="/get-all", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
        @ApiImplicitParam(name="page", paramType = "query", defaultValue = "1"),
        @ApiImplicitParam(name="limit", paramType = "query", defaultValue = "10"),
        @ApiImplicitParam(name="name", paramType = "query", defaultValue = "")   
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> findAll(@ApiIgnore AuctionFilter filter, @ApiIgnore Pagination pagination)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            pagination.setTotalCount(usr_service.count(filter));
            ArrayList<User> auction = (ArrayList<User>) usr_service.findAll(filter, pagination);
            if(!auction.isEmpty())
            {
                map.put("DATA", auction);
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
    
    
     @RequestMapping(value="/get-all-admin", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
        @ApiImplicitParam(name="page", paramType = "query", defaultValue = "1"),
        @ApiImplicitParam(name="limit", paramType = "query", defaultValue = "10"),
        @ApiImplicitParam(name="name", paramType = "query", defaultValue = "")   
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> findAllAdmin(@ApiIgnore AuctionFilter filter, @ApiIgnore Pagination pagination)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            pagination.setTotalCount(usr_service.countAdmin(filter));
            ArrayList<User> auction = (ArrayList<User>) usr_service.findAllAdmin(filter, pagination);
            if(!auction.isEmpty())
            {
                map.put("DATA", auction);
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
    
    @RequestMapping(value="/verifykey/{key}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> verifyKey(@PathVariable("key") String key)
    {
         Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            User customer = usr_service.comfirmEmail(key);
            if(customer!=null)
            {
                //map.put("DATA", customer);
                usr_service.activateAccount(customer.getCus_id());
                map.put("STATUS", true);
                map.put("MESSAGE", "Account activated!");
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
    
     @RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add_admin(@RequestBody User_feedback user)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(feedback.sendFeedback(user)){
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
  
    
}
