/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.modelPojo;

/**
 *
 * @author Farid
 */
public class ModelProduct {
    private int pro_Id;
     private String Pro_Name;

    public ModelProduct(int pro_Id, String Pro_Name) {
        this.pro_Id = pro_Id;
        this.Pro_Name = Pro_Name;
    }
   

    public ModelProduct() {
        
    }

    public ModelProduct(String Pro_Name) {
        this.Pro_Name = Pro_Name;
    }
    

    public String getPro_Name() {
        return Pro_Name;
    }

    public void setPro_Name(String Pro_Name) {
        this.Pro_Name = Pro_Name;
    }

    public int getPro_Id() {
        return pro_Id;
    }

    public void setPro_Id(int pro_Id) {
        this.pro_Id = pro_Id;
    }
}
