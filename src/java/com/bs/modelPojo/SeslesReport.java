/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.modelPojo;

import com.bs.pojo.Employee;
import com.bs.pojo.Product;
import java.io.Serializable;
import java.util.Date;

public class SeslesReport implements Serializable {

    private int empid;
    private int proid;
    private String proName;
    private Integer quantity;
    private Double total;
    private Date sellDate;
    private int memo;
    private double gtotl;

    public SeslesReport(int empid, int proid, String proName, Integer quantity, Double total, Date sellDate, int memo) {
        this.empid = empid;
        this.proid = proid;
        this.proName = proName;
        this.quantity = quantity;
        this.total = total;
        this.sellDate = sellDate;
        this.memo = memo;
        
    }

    public SeslesReport() {
    }

    public SeslesReport(int memo, double gtotl) {
        this.memo = memo;
        this.gtotl = gtotl;
    }

    public int getMemo() {
        return memo;
    }

    public void setMemo(int memo) {
        this.memo = memo;
    }

    public double getGtotl() {
        return gtotl;
    }

    public void setGtotl(double gtotl) {
        this.gtotl = gtotl;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

}
