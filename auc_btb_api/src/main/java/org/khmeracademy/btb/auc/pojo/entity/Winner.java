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
public class Winner {
    private String cus_firstname;
    private String cus_lastname;
    private String cus_phone;
    private String cus_email;
    private String cus_address;
    private String owner_firstname;
    private String owner_lastname;
    private String owner_phone;
    private String owner_email;
    private String owner_address;
    private Date end_date;
    private String status;
    private String current_price;
    private int bid_id;
    private int cus_id;
    private String pro_name;
    private int auc_id;

    /**
     * @return the cus_firstname
     */
    public String getCus_firstname() {
        return cus_firstname;
    }

    /**
     * @param cus_firstname the cus_firstname to set
     */
    public void setCus_firstname(String cus_firstname) {
        this.cus_firstname = cus_firstname;
    }

    /**
     * @return the cus_lastname
     */
    public String getCus_lastname() {
        return cus_lastname;
    }

    /**
     * @param cus_lastname the cus_lastname to set
     */
    public void setCus_lastname(String cus_lastname) {
        this.cus_lastname = cus_lastname;
    }

    /**
     * @return the cus_phone
     */
    public String getCus_phone() {
        return cus_phone;
    }

    /**
     * @param cus_phone the cus_phone to set
     */
    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    /**
     * @return the cus_email
     */
    public String getCus_email() {
        return cus_email;
    }

    /**
     * @param cus_email the cus_email to set
     */
    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    /**
     * @return the cus_address
     */
    public String getCus_address() {
        return cus_address;
    }

    /**
     * @param cus_address the cus_address to set
     */
    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
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
     * @return the current_price
     */
    public String getCurrent_price() {
        return current_price;
    }

    /**
     * @param current_price the current_price to set
     */
    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

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
