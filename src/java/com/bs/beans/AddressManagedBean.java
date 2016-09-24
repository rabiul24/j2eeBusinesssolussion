/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.AddressDao;

import com.bs.pojo.Address;
import com.bs.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Farid
 */
@Component
@ManagedBean(name ="a")
@RequestScoped
public class AddressManagedBean {
    
     public AddressManagedBean() {
      doViewAllAddress();
    }

    
 

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/address.xml");
    private Address address = (Address) ctx.getBean("address");
    AddressDao addressDao = (AddressDao) ctx.getBean("addressDao");
    private Employee employee = (Employee) ctx.getBean("employee");
    private List<Address> addressAllList = new ArrayList<>();  
    //not working in this moment.
    private List<Address> addressListById = new ArrayList<>();

   
    @Autowired
    public void doSaveAddress() {
        address.setEmployee(employee);
        boolean r = addressDao.doInsertAddress(address);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void deleteAddress() {
         address.setEmployee(employee);
        boolean r = addressDao.doDeleteAddress(address);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void updateAddress() {
         address.setEmployee(employee);
        boolean r = addressDao.doUpdateAddress(address);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doViewAllAddress() {
     addressAllList=addressDao.findAllAddress();   
    }

    @Autowired
    public void findAllAddressById() {
       address.setEmployee(employee);
        addressListById = addressDao.findAddressById(address.getAddressId());
        for(Address a : addressListById) {
            address.setVaillage(a.getVaillage());
            address.setUpazilla(a.getUpazilla());
            address.setDistrict(a.getDistrict());
            address.setPostCode(a.getPostCode());
//            address.setEmployee(a.getEmployee());
           
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAddressAllList() {
        return addressAllList;
    }

    public void setAddressAllList(List<Address> addressAllList) {
        this.addressAllList = addressAllList;
    }

    public List<Address> getAddressListById() {
        return addressListById;
    }

    public void setAddressListById(List<Address> addressListById) {
        this.addressListById = addressListById;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
 
}
