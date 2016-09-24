/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.ProductDao;
import com.bs.pojo.Product;
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
@ManagedBean(name = "p")
@RequestScoped
public class ProductManagedBean_1 {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/product.xml");
    private Product product = (Product) ctx.getBean("product");
    ProductDao productDao = (ProductDao) ctx.getBean("productdao");
    private List<Product> productAllList=new ArrayList<>();
    //not working in this moment.
    private List<Product> productListById=new ArrayList<>();

    public List<Product> getProductListById() {
        return productListById;
    }

    public void setProductListById(List<Product> productListById) {
        this.productListById = productListById;
    }

    public ProductManagedBean_1() {
        doViewAllProduct();
    }
    

    @Autowired
    public void doInsertProduct() {

        boolean r = productDao.doInsertProduct(product);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doUpdateProduct() {

        boolean r = productDao.doUpdateProduct(product);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doDeleteProduct() {
        boolean r = productDao.doDeleteProduct(product);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }
    @Autowired
    public void doViewAllProduct() {
     productAllList = productDao.findAllProduct();
   
     
      
    }
    @Autowired
    public void findAllProductById() {
        
     productListById = productDao.findByProductId(product.getProId());
      for(Product p:productListById){
          product.setProName(p.getProName());
      }
      
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductAllList() {
        return productAllList;
    }

    public void setProductAllList(List<Product> productAllList) {
        this.productAllList = productAllList;
    }

  
}
