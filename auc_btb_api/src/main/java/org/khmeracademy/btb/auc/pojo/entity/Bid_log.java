/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

import java.util.Date;

/**
 *
 * @author KUYLIM
 */
public class Bid_log {
    private int bid_id;
    private double current_price;
    private Date date;
    private int auc_id;
    private int usr_id;
    private int number_of_bid;

    /**
     * @return the bid_id
     */
    public int getBid_id() {
        return bid_id;
    }

    /**
     * @param bid_id the bid_id to set
     */
    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    /**
     * @return the current_price
     */
    public double getCurrent_price() {
        return current_price;
    }

    /**
     * @param current_price the current_price to set
     */
    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    /**
     * @return the date
     */
    
    /**
     * @return the auc_id
     */
    public int getAuc_id() {
        return auc_id;
    }

    /**
     * @param auc_id the auc_id to set
     */
    public void setAuc_id(int auc_id) {
        this.auc_id = auc_id;
    }

    /**
     * @return the usr_id
     */
    public int getCus_id() {
        return usr_id;
    }

    /**
     * @param cus_id the usr_id to set
     */
    public void setCus_id(int usr_id) {
        this.usr_id = usr_id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the number_of_bid
     */
    public int getNumber_of_bid() {
        return number_of_bid;
    }

    /**
     * @param number_of_bid the number_of_bid to set
     */
    public void setNumber_of_bid(int number_of_bid) {
        this.number_of_bid = number_of_bid;
    }
}
