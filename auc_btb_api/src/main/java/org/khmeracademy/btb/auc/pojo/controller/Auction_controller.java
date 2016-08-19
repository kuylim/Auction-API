/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.Auction;
import org.khmeracademy.btb.auc.pojo.entity.Auction_Detail;
import org.khmeracademy.btb.auc.pojo.entity.Auction_history;
import org.khmeracademy.btb.auc.pojo.service.Auction_service;
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
@RequestMapping(value = "/api/auction")
public class Auction_controller {
    @Autowired
    private Auction_service auc_service;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAuctions(@RequestParam(value = "page", required = false , defaultValue="1") int page 
            , @RequestParam(value="limit" , required = false , defaultValue="6") int limit)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
            pagination.setLimit(limit);
            pagination.setPage(page);
            pagination.setTotalCount(auc_service.countAuction());
            ArrayList<Auction_Detail> auction = auc_service.getAuctions(pagination);
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
    
    @RequestMapping(value="/get-by-category/{cat_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAuctionsByCategory(@RequestParam(value = "page", required = false , defaultValue="1") int page 
            , @RequestParam(value="limit" , required = false , defaultValue="6") int limit, @PathVariable("cat_id") int id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
            pagination.setLimit(limit);
            pagination.setPage(page);
            pagination.setTotalCount(auc_service.countAuctionByCategory(id));
            ArrayList<Auction_Detail> auction = auc_service.getAuctionsByCategory(pagination,id);
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
    
    @RequestMapping(value="/get-by-brand/{brand_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAuctionsByBrand(@RequestParam(value = "page", required = false , defaultValue="1") int page 
            , @RequestParam(value="limit" , required = false , defaultValue="6") int limit, @PathVariable("brand_id") int id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
            pagination.setLimit(limit);
            pagination.setPage(page);
            pagination.setTotalCount(auc_service.countAuctionByBrand(id));
            ArrayList<Auction_Detail> auction = auc_service.getAuctionsByBrand(pagination,id);
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
    
    
    @RequestMapping(value="/get-history/{usr_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAuctionsHistoryByUser(@PathVariable("usr_id") int id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Pagination pagination = new Pagination();
//            pagination.setLimit(limit);
//            pagination.setPage(page);
            //pagination.setTotalCount(auc_service.countAuctionByBrand(id));
            ArrayList<Auction_history> auction = auc_service.getAuctionHistoryByUser(id);
            if(!auction.isEmpty())
            {
                map.put("DATA", auction);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND!");
                //map.put("PAGINATION", pagination);
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
    
//    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") int id)
    {
        Map<String, Object> map = new HashMap<String , Object>();
        try{
            if(auc_service.remove(id)){
		map.put("MESSAGE", "Auction has been deleted");
		map.put("STATUS", true);
            }
            else
            {
		map.put("MESSAGE", "Auction has not been deleted");
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
//
//    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> add(@RequestBody Auction auction)
    {
       Map<String, Object> map = new HashMap<String , Object>();
        try{
            
            if(auc_service.save(auction)){
		map.put("MESSAGE", "Auction has been inserted.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Auction has not been inserted.");
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
//    
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> edit(@RequestBody Auction auction)
    {
         Map<String, Object> map = new HashMap<String , Object>();
         try{
            
            if(auc_service.update(auction)){
		map.put("MESSAGE", "Auction has been updated.");
		map.put("STATUS", true);
            }else
            {
		map.put("MESSAGE", "Auction has not been updated.");
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
            Auction_Detail auc_detail = auc_service.search(id);
            if(auc_detail!=null)
            {
                map.put("DATA", auc_detail);
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
    
    @RequestMapping(value="/update-current-price/{id}/{price}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> update_currentprice (@PathVariable("id") int id, @PathVariable("price") double price)
    {
        Map<String, Object> map = new HashMap<String , Object>();
        try{
            if(auc_service.update_currentprice(price, id)){
		map.put("MESSAGE", "Auction has been update current price");
		map.put("STATUS", true);
            }
            else
            {
		map.put("MESSAGE", "Auction has not been update current price");
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
