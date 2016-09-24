/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.modelPojo.ModelProduct;
import com.bs.pojo.Purchases;
import com.bs.pojo.Sales;
import java.util.List;

/**
 *
 * @author apcl
 */
public interface SalesModel {
    public List<Sales> findAll(Sales s);
    public List<ModelProduct> purductName();
    public void createPurForm();
    public boolean doInsert(Sales sales);
}
