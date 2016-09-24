/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;


import com.bs.pojo.Supplier;
import java.util.List;

/**
 *
 * @author User
 */
public interface SupplierModel {

    public boolean doInsertSupplier(Supplier supplier);

    public boolean doUpdateSupplier(Supplier supplier);

    public boolean doDeleteSupplier(Supplier supplier);

    public List<Supplier> findAllSupplier();

    public List<Supplier> findBySupplierId(int suppId);
}
