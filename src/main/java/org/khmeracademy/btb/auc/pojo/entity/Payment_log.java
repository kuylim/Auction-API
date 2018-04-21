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
public class Payment_log {
    private int pay_id;
    private double amount;
    private String date;
    private int paym_id;
    private int cus_id;
    private int auc_id;

    /**
     * @return the pay_id
     */
    public int getPay_id() {
        return pay_id;
    }

    /**
     * @param pay_id the pay_id to set
     */
    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
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
