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
public class Auction {
    private int auc_id;
    private String product_condition;
    private double start_price;
    private double buy_price;
    private double bid_increment_price;
    private double current_price;
    private Date start_date;
    private Date end_date;
    private String status;
    private int owner_id;
    private int usr_id;
    private int pro_id;
    private String name;
    private String image;
    

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
     * @return the product_condition
     */
    public String getProduct_condition() {
        return product_condition;
    }

    /**
     * @param product_condition the product_condition to set
     */
    public void setProduct_condition(String product_condition) {
        this.product_condition = product_condition;
    }

    /**
     * @return the start_price
     */
    public double getStart_price() {
        return start_price;
    }

    /**
     * @param start_price the start_price to set
     */
    public void setStart_price(double start_price) {
        this.start_price = start_price;
    }

    /**
     * @return the buy_price
     */
    public double getBuy_price() {
        return buy_price;
    }

    /**
     * @param buy_price the buy_price to set
     */
    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    /**
     * @return the bid_increment_price
     */
    public double getBid_increment_price() {
        return bid_increment_price;
    }

    /**
     * @param bid_increment_price the bid_increment_price to set
     */
    public void setBid_increment_price(double bid_increment_price) {
        this.bid_increment_price = bid_increment_price;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the owner_id
     */
    public int getOwner_id() {
        return owner_id;
    }

    /**
     * @param owner_id the owner_id to set
     */
    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    /**
     * @return the usr_id
     */
    public int getUsr_id() {
        return usr_id;
    }

    /**
     * @param usr_id the usr_id to set
     */
    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }

    /**
     * @return the pro_id
     */
    public int getPro_id() {
        return pro_id;
    }

    /**
     * @param pro_id the pro_id to set
     */
    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the start_date
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the end_date
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
