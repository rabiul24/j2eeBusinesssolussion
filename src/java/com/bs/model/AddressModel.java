/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Address;
import java.util.List;

public interface AddressModel {
    public boolean doInsertAddress(Address address);
    public boolean doUpdateAddress(Address address);
    public boolean doDeleteAddress(Address address);
    public List<Address> findAllAddress();
    public List<Address> findAddressById(int addressId);
    
    
}
