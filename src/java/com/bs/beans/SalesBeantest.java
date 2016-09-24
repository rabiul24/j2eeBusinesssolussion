/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.SalesDao;
import com.bs.pojo.Sales;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Component;
@Component
@ManagedBean
@SessionScoped
public class SalesBeantest {
    Sales sal=new Sales();
    List<Sales> sales=new ArrayList<>();
    public SalesBeantest() {
        sales=new SalesDao().findAll(sal);
    }
    
}
