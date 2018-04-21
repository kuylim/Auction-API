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
public class Brand {
    private int brand_id;
    private String name;
    private String description;
    private boolean status;
    private int number_of_brand;
    /**
     * @return the brand_id
     */
    public int getBrand_id() {
        return brand_id;
    }

    /**
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the number_of_brand
     */
    public int getNumber_of_brand() {
        return number_of_brand;
    }

    /**
     * @param number_of_brand the number_of_brand to set
     */
    public void setNumber_of_brand(int number_of_brand) {
        this.number_of_brand = number_of_brand;
    }
}
