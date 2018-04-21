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
import org.khmeracademy.btb.auc.pojo.entity.Brand;
import org.khmeracademy.btb.auc.pojo.entity.Category;
import org.khmeracademy.btb.auc.pojo.filtering.AuctionFilter;
import org.khmeracademy.btb.auc.pojo.service.Brand_service;
import org.khmeracademy.btb.auc.pojo.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author KUYLIM
 */
@RestController
@RequestMapping(value = "/api/brand")
public class Brand_controller {
    @Autowired
    private Brand_service bra_service;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductBrands()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            ArrayList<Brand> brand = bra_service.getProductBrand();
            if(!brand.isEmpty())
            {
                map.put("DATA", brand);
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
    
    @RequestMapping(value="/get-number-auction-in-brand", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getNumberAuctionInBrand()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            ArrayList<Brand> brand = bra_service.getNumberOfAuctionInBrand();
            if(!brand.isEmpty())
            {
                map.put("DATA", brand);
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
            if(bra_service.remove(id)){
		map.put("MESSAGE", "Product brand has been deleted");
		map.put("STATUS", true);
            }
            else
            {
		map.put("MESSAGE", "Product brand has not been deleted");
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
    public ResponseEntity<Map<String, Object>> add(@RequestBody Brand brand)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(bra_service.save(brand)){
		map.put("MESSAGE", "Product brand has been inserted.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Product brand has not been inserted.");
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
    public ResponseEntity<Map<String, Object>> edit(@RequestBody Brand brand)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(bra_service.update(brand)){
		map.put("MESSAGE", "Product brand has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Product brand has not been updated.");
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
            Brand brand = bra_service.search(id);
            if(brand!=null)
            {
                map.put("DATA", brand);
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
            pagination.setTotalCount(bra_service.count(filter));
            ArrayList<Brand> auction = (ArrayList<Brand>) bra_service.findAll(filter, pagination);
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
}
