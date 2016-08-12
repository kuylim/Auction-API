/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.Customer;
import org.khmeracademy.btb.auc.pojo.entity.UserLogin;
import org.khmeracademy.btb.auc.pojo.service.Customer_service;
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

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/api/customer")
public class Customer_controller {
     @Autowired
    private Customer_service cus_service;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getCustomer(
            @RequestParam(value = "page", required = false , defaultValue="1") int page 
            , @RequestParam(value="limit" , required = false , defaultValue="12") int limit)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
            pagination.setLimit(limit);
            pagination.setPage(page);
            pagination.setTotalCount(cus_service.countCustomer());
            ArrayList<Customer> customer = cus_service.getCustomers(pagination);
            
            if(!customer.isEmpty())
            {
                map.put("DATA", customer);
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
            if(cus_service.remove(id)){
		map.put("MESSAGE", "Customer has been deleted");
		map.put("STATUS", true);
            }
            else
            {
		map.put("MESSAGE", "Customer has not been deleted");
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
    public ResponseEntity<Map<String, Object>> add(@RequestBody Customer customer)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(cus_service.save(customer)){
		map.put("MESSAGE", "Customer has been inserted.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Customer has not been inserted.");
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
    public ResponseEntity<Map<String, Object>> edit(@RequestBody Customer customer)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(cus_service.update(customer)){
		map.put("MESSAGE", "Customer has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Customer has not been updated.");
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
            Customer customer = cus_service.search(id);
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
    public ResponseEntity<Map<String, Object>> updateBalance(@RequestBody Customer customer)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(cus_service.updateBalance(customer)){
		map.put("MESSAGE", "Customer balance has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Customer balance has not been updated.");
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
                    map.put("DATA", cus_service.findUserByEmail(login.getEmail()) );
                    System.out.println(map);
			
		}catch(Exception e){
			map.put("STATUS",false);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
    
}
