/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.SupplierDao;
import com.bs.pojo.Employee;
import com.bs.pojo.Location;
import com.bs.pojo.Suppervisor;
import com.bs.pojo.Supplier;
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
 * @author User
 */
@Component
@ManagedBean(name = "su")
@RequestScoped
public class SupplierManageBean {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/supplier.xml");
    private Supplier supplier = (Supplier) ctx.getBean("supplier");
    SupplierDao supplierDao = (SupplierDao) ctx.getBean("supplierdao");
    
    private Location location = (Location) ctx.getBean("location");
    private Employee employee = (Employee) ctx.getBean("employee");
   private Suppervisor suppervisor = (Suppervisor) ctx.getBean("suppervisor");
   
    private List<Supplier> supplierListById=new ArrayList<>();
     private List<Supplier> supplierAllList=new ArrayList<>();



    public SupplierManageBean() {
        doViewAllSupplier();
    }
    

    @Autowired
    public void doInsertSupplier() {
        supplier.setLocation(location);
        supplier.setEmployee(employee);
        supplier.setSuppervisor(suppervisor);
        
        boolean r = supplierDao.doInsertSupplier(supplier);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doUpdateSupplier() {
           supplier.setLocation(location);
           supplier.setEmployee(employee);
           supplier.setSuppervisor(suppervisor);
           
        boolean r = supplierDao.doUpdateSupplier(supplier);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doDeleteSupplier() {
       supplier.setLocation(location);
       supplier.setEmployee(employee);
       supplier.setSuppervisor(suppervisor);
       
        boolean r = supplierDao.doDeleteSupplier(supplier);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doViewAllSupplier() {
       supplierAllList = supplierDao.findAllSupplier();
   }
    @Autowired
    public void findAllSupplierById() {
        
     supplierListById = supplierDao.findBySupplierId(supplier.getSuppId());
      for(Supplier su:supplierListById){
            supplier.setSuppName(su.getSuppName());
      }
      
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Suppervisor getSuppervisor() {
        return suppervisor;
    }

    public void setSuppervisor(Suppervisor suppervisor) {
        this.suppervisor = suppervisor;
    }


    public List<Supplier> getSupplierAllList() {
        return supplierAllList;
    }

    public void setSupplierAllList(List<Supplier> supplierAllList) {
        this.supplierAllList = supplierAllList;
    }

    
   

  
}


