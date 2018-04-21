/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Auction_history {
    private String pro_name;
    private String pro_info;
    private String pro_condition;
    private double auc_start_price;
    private double auc_buy_price;
    private double auc_bid_increment;
    private double auc_current_price;
    private Date auc_start_date;
    private Date auc_end_date;
    private boolean auc_status;
    private String owner_firstname;
    private String owner_lastname;
    private String owner_phone;
    private String owner_email;
    private String owner_address;
    private String owner_com_profile;
    private String user_firstname;
    private String user_lastname;
    private String user_phone;
    private String user_email;
    private String user_address;
    private Date bid_date;
    private int auc_id;
    private int usr_id;
    private int owner_id;
    private int bid_log_id;
    private int pro_id;
    private List<Image> images;

    /**
     * @return the pro_name
     */
    public String getPro_name() {
        return pro_name;
    }

    /**
     * @param pro_name the pro_name to set
     */
    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    /**
     * @return the pro_condition
     */
    public String getPro_condition() {
        return pro_condition;
    }

    /**
     * @param pro_condition the pro_condition to set
     */
    public void setPro_condition(String pro_condition) {
        this.pro_condition = pro_condition;
    }

    /**
     * @return the auc_start_price
     */
    public double getAuc_start_price() {
        return auc_start_price;
    }

    /**
     * @param auc_start_price the auc_start_price to set
     */
    public void setAuc_start_price(double auc_start_price) {
        this.auc_start_price = auc_start_price;
    }

    /**
     * @return the auc_buy_price
     */
    public double getAuc_buy_price() {
        return auc_buy_price;
    }

    /**
     * @param auc_buy_price the auc_buy_price to set
     */
    public void setAuc_buy_price(double auc_buy_price) {
        this.auc_buy_price = auc_buy_price;
    }

    /**
     * @return the auc_bid_increment
     */
    public double getAuc_bid_increment() {
        return auc_bid_increment;
    }

    /**
     * @param auc_bid_increment the auc_bid_increment to set
     */
    public void setAuc_bid_increment(double auc_bid_increment) {
        this.auc_bid_increment = auc_bid_increment;
    }

    /**
     * @return the auc_current_price
     */
    public double getAuc_current_price() {
        return auc_current_price;
    }

    /**
     * @param auc_current_price the auc_current_price to set
     */
    public void setAuc_current_price(double auc_current_price) {
        this.auc_current_price = auc_current_price;
    }

    /**
     * @return the auc_start_date
     */
    public Date getAuc_start_date() {
        return auc_start_date;
    }

    /**
     * @param auc_start_date the auc_start_date to set
     */
    public void setAuc_start_date(Date auc_start_date) {
        this.auc_start_date = auc_start_date;
    }

    /**
     * @return the auc_end_date
     */
    public Date getAuc_end_date() {
        return auc_end_date;
    }

    /**
     * @param auc_end_date the auc_end_date to set
     */
    public void setAuc_end_date(Date auc_end_date) {
        this.auc_end_date = auc_end_date;
    }

    /**
     * @return the auc_status
     */
    public boolean isAuc_status() {
        return auc_status;
    }

    /**
     * @param auc_status the auc_status to set
     */
    public void setAuc_status(boolean auc_status) {
        this.auc_status = auc_status;
    }

    /**
     * @return the owner_firstname
     */
    public String getOwner_firstname() {
        return owner_firstname;
    }

    /**
     * @param owner_firstname the owner_firstname to set
     */
    public void setOwner_firstname(String owner_firstname) {
        this.owner_firstname = owner_firstname;
    }

    /**
     * @return the owner_lastname
     */
    public String getOwner_lastname() {
        return owner_lastname;
    }

    /**
     * @param owner_lastname the owner_lastname to set
     */
    public void setOwner_lastname(String owner_lastname) {
        this.owner_lastname = owner_lastname;
    }

    /**
     * @return the owner_phone
     */
    public String getOwner_phone() {
        return owner_phone;
    }

    /**
     * @param owner_phone the owner_phone to set
     */
    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    /**
     * @return the owner_email
     */
    public String getOwner_email() {
        return owner_email;
    }

    /**
     * @param owner_email the owner_email to set
     */
    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    /**
     * @return the owner_address
     */
    public String getOwner_address() {
        return owner_address;
    }

    /**
     * @param owner_address the owner_address to set
     */
    public void setOwner_address(String owner_address) {
        this.owner_address = owner_address;
    }

    /**
     * @return the owner_com_profile
     */
    public String getOwner_com_profile() {
        return owner_com_profile;
    }

    /**
     * @param owner_com_profile the owner_com_profile to set
     */
    public void setOwner_com_profile(String owner_com_profile) {
        this.owner_com_profile = owner_com_profile;
    }

    /**
     * @return the user_firstname
     */
    public String getUser_firstname() {
        return user_firstname;
    }

    /**
     * @param user_firstname the user_firstname to set
     */
    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    /**
     * @return the user_lastname
     */
    public String getUser_lastname() {
        return user_lastname;
    }

    /**
     * @param user_lastname the user_lastname to set
     */
    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    /**
     * @return the user_phone
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * @param user_phone the user_phone to set
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    /**
     * @return the user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email the user_email to set
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * @return the user_address
     */
    public String getUser_address() {
        return user_address;
    }

    /**
     * @param user_address the user_address to set
     */
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    /**
     * @return the bid_date
     */
    public Date getBid_date() {
        return bid_date;
    }

    /**
     * @param bid_date the bid_date to set
     */
    public void setBid_date(Date bid_date) {
        this.bid_date = bid_date;
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
     * @return the bid_log_id
     */
    public int getBid_log_id() {
        return bid_log_id;
    }

    /**
     * @param bid_log_id the bid_log_id to set
     */
    public void setBid_log_id(int bid_log_id) {
        this.bid_log_id = bid_log_id;
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
     * @return the pro_info
     */
    public String getPro_info() {
        return pro_info;
    }

    /**
     * @param pro_info the pro_info to set
     */
    public void setPro_info(String pro_info) {
        this.pro_info = pro_info;
    }

    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }
}
