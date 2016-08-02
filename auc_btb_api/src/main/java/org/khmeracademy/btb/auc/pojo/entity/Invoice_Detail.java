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
public class Invoice_Detail {
    private double buy_price;
    private int inv_id;
    private int pro_id;
    private int auc_id;

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
