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
public class Invoice {
    private int inv_id;
    private String date;
    private int cus_id;

    /**
     * @return the inv_id
     */
    public int getInv_id() {
        return inv_id;
    }

    /**
     * @param inv_id the inv_id to set
     */
    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
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
