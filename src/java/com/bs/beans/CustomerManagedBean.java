/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;
import com.bs.dao.CustomerDao;
import com.bs.pojo.Customer;
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
 * @author use
 */
@Component
@ManagedBean(name = "cust")
@RequestScoped
public class CustomerManagedBean {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/customer.xml");
    private Customer customer = (Customer) ctx.getBean("customer");
    CustomerDao customerDao = (CustomerDao) ctx.getBean("customerdao");
    private List<Customer> customerAllList=new ArrayList<>();
    //not working in this moment.
    private List<Customer> customerListById=new ArrayList<>();



    public CustomerManagedBean() {
        doViewAllCustomer();
    }
    

    @Autowired
    public void doInsertCustomer() {
        boolean r = customerDao.doInsertCustomer(customer);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doUpdateCustomer() {

        boolean r = customerDao.doUpdateCustomer(customer);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doDeleteCustomer() {
        boolean r = customerDao.doDeleteCustomer(customer);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doViewAllCustomer() {
     customerAllList = customerDao.findAllCustomer();
   
     
      
    }
    @Autowired
    public void findAllCustomerById() {
        
     customerListById = customerDao.findByCustomerId(customer.getCustId());
      for(Customer cust:customerListById){
          customer.setCustName(cust.getCustName());
          customer.setLocation(cust.getLocation());
          customer.setShopName(cust.getShopName());
      }
      
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerAllList() {
        return customerAllList;
    }

    public void setCustomerAllList(List<Customer> customerAllList) {
        this.customerAllList = customerAllList;
    }

    public List<Customer> getCustomerListById() {
        return customerListById;
    }

    public void setCustomerListById(List<Customer> customerListById) {
        this.customerListById = customerListById;
    }

    
    
}
