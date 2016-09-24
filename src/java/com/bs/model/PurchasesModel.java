/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.modelPojo.ModelProduct;
import com.bs.modelPojo.ModelPurchases;
import com.bs.pojo.Purchases;
import java.util.List;

/**
 *
 * @author Farid
 */
public interface PurchasesModel {
    public List<ModelProduct> purductName();
    public void createPurForm();
    public boolean doInsert(Purchases pur);
}
