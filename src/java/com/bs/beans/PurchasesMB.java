/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.PurchasesDao;
import com.bs.database.DB;
import com.bs.modelPojo.ModelProduct;
import com.bs.modelPojo.ModelPurchases;
import com.bs.pojo.Product;
import com.bs.pojo.Purchases;
import com.bs.util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Farid
 */
@Component
@ManagedBean(name = "pur")
@SessionScoped
public class PurchasesMB extends PurchasesDao {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/purchases.xml");
    private PurchasesDao mb = (PurchasesDao) ctx.getBean("purchasesDao2");
    private ModelPurchases mPur = (ModelPurchases) ctx.getBean("modelPur");
    private Purchases pur = (Purchases) ctx.getBean("purchasebean");
    private Product pro = (Product) ctx.getBean("product1");
    
    private List<ModelProduct> productList = new ArrayList<ModelProduct>();
    private Set<String> selectedPoduct2;
    private Set<String> selectedPoduct;
    private Set<ModelProduct> modelPurForm = new HashSet<>();

    private List<ModelProduct> modelPurForm2 = new ArrayList<>();

    private String[] serialNo = new String[1024];
    private Double[] unitPrice = new Double[1024];
    private Integer[] qty = new Integer[1024];
    private Double[] totalPrice = new Double[1024];

    @Future
    private Date date;

    private double test;
    private double test2;
    private double test3;
    private boolean doAct = true;

    public PurchasesMB() {
        productList = mb.purductName();
        modelPurForm2.add(new ModelProduct("a"));
        modelPurForm2.add(new ModelProduct("b"));

        //productList.add(new ModelProduct(1, "A"));
    }

    public void doSave() {
        boolean r = false;
        String r2=null;

        try {

            for (String p : selectedPoduct) {
                
                for (ModelProduct p2 : productList) {
                    
                    if (p2.getPro_Name().equals(p)) {
                        
                        if (mb.doInsCheck(date, serialNo[p2.getPro_Id()])) {
                            
//                            for (ModelProduct p1 : productList) {
//                                if (p1.getPro_Name().equals(p)) {
//                                    Session s = HibernateUtil.getSessionFactory().openSession();
//                                    s.beginTransaction();
//                                    pro.setProId(p1.getPro_Id());
//                                    pur.setProduct(pro);
//                                    pur.setPurName(p1.getPro_Name());
//                                    pur.setSerialNo(serialNo[p1.getPro_Id()]);
//                                    pur.setPurchasesDate(date);
//                                    pur.setPrice(unitPrice[p1.getPro_Id()]);
//                                    pur.setQuantity(qty[p1.getPro_Id()]);
//                                    pur.setTotalPrice(totalPrice[p1.getPro_Id()]);
//
//                                    s.save(pur);
//                                    s.getTransaction().commit();
//                                    s.close();
//                                    System.out.println("hello");
//                                }
//                            }
                                r2="Duplicate Product not allow";
                        } else {
                            for (ModelProduct p1 : productList) {
                                if (p1.getPro_Name().equals(p)) {
                                    Session s = HibernateUtil.getSessionFactory().openSession();
                                    s.beginTransaction();
                                    pro.setProId(p1.getPro_Id());
                                    pur.setProduct(pro);
                                    pur.setPurName(p1.getPro_Name());
                                    pur.setSerialNo(serialNo[p1.getPro_Id()]);
                                    pur.setPurchasesDate(date);
                                    pur.setPrice(unitPrice[p1.getPro_Id()]);
                                    pur.setQuantity(qty[p1.getPro_Id()]);
                                    pur.setTotalPrice(totalPrice[p1.getPro_Id()]);

                                    s.save(pur);
                                    s.getTransaction().commit();
                                    s.close();
                                    r2="Saved";
                                }
                            }
                        }
                    }

                }

            }

            this.addMessage(r2);

        } catch (Exception e) {
            this.addMessage("Plase check date");
        }

    }

    public void cTotalPrice(int c) {
        totalPrice[c] = unitPrice[c] * qty[c];

    }

    public void createPurForm() {
        modelPurForm.clear();
        Connection con = null;
        PreparedStatement stm = null;
        List<ModelPurchases> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            con = DB.getConnection();
            String sql = "SELECT Pro_Id FROM product WHERE Pro_Name=?;";
            stm = con.prepareStatement(sql);
            for (String p : selectedPoduct) {
                stm.setString(1, p.toString());
                rs = stm.executeQuery();
                //System.out.println(p);
                while (rs.next()) {
                    modelPurForm.add(new ModelProduct(rs.getInt(1), p));
                    System.out.println(rs.getInt(1));
                }

            }
            // selectedPoduct.clear();

            //setDoAct(true);
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PurchasesMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cTotalPrice2() {
        test3 = modelPurForm.size();
    }

    public void test() {
        for (ModelProduct p : productList) {
            System.out.println(p.getPro_Id());
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product();
        Purchases p2 = new Purchases();
        PurchasesDao p3 = new PurchasesDao();
        PurchasesMB mb = new PurchasesMB();
        mb.test();

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setMb(PurchasesDao mb) {
        this.mb = mb;
    }

    public void doFindProduct() {
        productList = mb.purductName();

    }

    public List<ModelProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<ModelProduct> productList) {
        this.productList = productList;
    }

    public String[] getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String[] serialNo) {
        this.serialNo = serialNo;
    }

    public Double[] getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double[] unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer[] getQty() {
        return qty;
    }

    public void setQty(Integer[] qty) {
        this.qty = qty;
    }

    public Double[] getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double[] totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTest() {
        return test;
    }

    public void setTest(double test) {
        this.test = test;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    public List<ModelProduct> getModelPurForm2() {
        return modelPurForm2;
    }

    public void setModelPurForm2(List<ModelProduct> modelPurForm2) {
        this.modelPurForm2 = modelPurForm2;
    }

    public double getTest3() {
        return test3;
    }

    public void setTest3(double test3) {
        this.test3 = test3;
    }

    public Set<String> getSelectedPoduct() {
        return selectedPoduct;
    }

    public void setSelectedPoduct(Set<String> selectedPoduct) {
        this.selectedPoduct = selectedPoduct;
    }

    public boolean isDoAct() {
        return doAct;
    }

    public void setDoAct(boolean doAct) {
        this.doAct = doAct;
    }

    public Set<String> getSelectedPoduct2() {
        return selectedPoduct2;
    }

    public void setSelectedPoduct2(Set<String> selectedPoduct2) {
        this.selectedPoduct2 = selectedPoduct2;
    }

    public Set<ModelProduct> getModelPurForm() {
        return modelPurForm;
    }

    public void setModelPurForm(Set<ModelProduct> modelPurForm) {
        this.modelPurForm = modelPurForm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
