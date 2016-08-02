/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

/**
 *
 * @author User
 */
public class Topup_log {
    private int topup_id;
    private double amount;
    private String date;
    private int cus_id;
    private int paym_id;

    /**
     * @return the topup_id
     */
    public int getTopup_id() {
        return topup_id;
    }

    /**
     * @param topup_id the topup_id to set
     */
    public void setTopup_id(int topup_id) {
        this.topup_id = topup_id;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
}
