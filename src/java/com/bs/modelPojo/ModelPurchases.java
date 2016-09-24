/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.modelPojo;

import java.util.Date;

/**
 *
 * @author Farid
 */
public class ModelPurchases {

    private int pro_Id;
    private String pro_Name;
    private String serialNo;
    private Date purchases_Date;
    private double price;
    private int puantity;
    private double total_Price;

    public ModelPurchases(int pro_Id, String pro_Name, String serialNo, Date purchases_Date, double price, int puantity, double total_Price) {
        this.pro_Id = pro_Id;
        this.pro_Name = pro_Name;
        this.serialNo = serialNo;
        this.purchases_Date = purchases_Date;
        this.price = price;
        this.puantity = puantity;
        this.total_Price = total_Price;
    }

    public ModelPurchases() {
    }

    public int getPro_Id() {
        return pro_Id;
    }

    public void setPro_Id(int pro_Id) {
        this.pro_Id = pro_Id;
    }

    public String getPro_Name() {
        return pro_Name;
    }

    public void setPro_Name(String pro_Name) {
        this.pro_Name = pro_Name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getPurchases_Date() {
        return purchases_Date;
    }

    public void setPurchases_Date(Date purchases_Date) {
        this.purchases_Date = purchases_Date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPuantity() {
        return puantity;
    }

    public void setPuantity(int puantity) {
        this.puantity = puantity;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }
}
