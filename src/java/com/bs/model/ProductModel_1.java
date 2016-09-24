/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Product;
import java.util.List;

public interface ProductModel_1 {
    public boolean doInsertProduct(Product product);
    public boolean doUpdateProduct(Product product);
    public boolean doDeleteProduct(Product product);
    public List<Product> findAllProduct();
    public List<Product> findByProductId(int proId);
    
    
}
