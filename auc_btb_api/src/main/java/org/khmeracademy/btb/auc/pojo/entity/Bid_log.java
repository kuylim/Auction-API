/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

/**
 *
 * @author KUYLIM
 */
public class Bid_log {
    private int bid_id;
    private double current_price;
    private String date;
    private int auc_id;
    private int cus_id;

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
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

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
     * @return the cus_id
     */
    public int getCus_id() {
        return cus_id;
    }

    /**
     * @param cus_id the cus_id to set
     */
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
}
