/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

import java.util.Date;

/**
 *
 * @author User
 */
public class Auction_Detail {
    private String product_condition;
    private double start_price;
    private double buy_price;
    private double current_price;
    private double bid_increment_price;
    private Date start_date;
    private Date end_date;
    private String image;
    private String name;
    private String pro_info;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    private String company_profile;
    private int Number_of_bids;
    private int auc_id;

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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the company_profile
     */
    public String getCompany_profile() {
        return company_profile;
    }

    /**
     * @param company_profile the company_profile to set
     */
    public void setCompany_profile(String company_profile) {
        this.company_profile = company_profile;
    }

    /**
     * @return the Number_of_bids
     */
    public int getNumber_of_bids() {
        return Number_of_bids;
    }

    /**
     * @param Number_of_bids the Number_of_bids to set
     */
    public void setNumber_of_bids(int Number_of_bids) {
        this.Number_of_bids = Number_of_bids;
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
}
