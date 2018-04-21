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
public class Payment_method {
    private int paym_id;
    private String mehtod_name;

    /**
     * @return the paym_id
     */
    public int getPaym_id() {
        return paym_id;
    }

    /**
     * @param paym_id the paym_id to set
     */
    public void setPaym_id(int paym_id) {
        this.paym_id = paym_id;
    }

    /**
     * @return the mehtod_name
     */
    public String getMehtod_name() {
        return mehtod_name;
    }

    /**
     * @param mehtod_name the mehtod_name to set
     */
    public void setMehtod_name(String mehtod_name) {
        this.mehtod_name = mehtod_name;
    }
}
