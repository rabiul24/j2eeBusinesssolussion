/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;
import com.bs.pojo.Customer;
import java.util.List;

/**
 *
 * @author use
 */
public interface CustomerModel {
    public boolean doInsertCustomer(Customer customer);
    public boolean doUpdateCustomer(Customer customer);
    public boolean doDeleteCustomer(Customer customer);
    public List<Customer> findAllCustomer();
    public List<Customer> findByCustomerId(int custId);
}
