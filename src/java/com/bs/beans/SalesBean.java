/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.PurchasesDao;
import com.bs.dao.SalesDao;
import com.bs.database.DB;
import com.bs.modelPojo.ModelProduct;
import com.bs.modelPojo.ModelPurchases;
import com.bs.modelPojo.SeslesReport;
import com.bs.pojo.Employee;
import com.bs.pojo.Product;
import com.bs.pojo.Sales;
import com.bs.util.HibernateUtil;
import java.io.Serializable;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Farid
 */
@Component
@ManagedBean
@SessionScoped
public class SalesBean extends PurchasesDao {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/sales.xml");
    private SalesDao mb = (SalesDao) ctx.getBean("salesDao");
    private ModelPurchases mPur = (ModelPurchases) ctx.getBean("modelPur");
    private Sales pur = (Sales) ctx.getBean("salesBean");
    private Product pro = (Product) ctx.getBean("salesProduct");
    private SeslesReport sreport = (SeslesReport) ctx.getBean("salesReport");
    private final static String[] PRODUCTNAME = {"NCAFE", "NIDO", "Cerelac", "BFCP", "Kitkat", "Horlicks", "DCM", "printer", "Monitor", "aram", "tcpa", "Sprite", "Coca", "Mrnda", "Clemon"};
    private Employee emp = new Employee();
    private List<ModelProduct> productList = new ArrayList<ModelProduct>();
    private Set<String> selectedPoduct;
    private Set<ModelProduct> modelPurForm = new HashSet<ModelProduct>();
    private Integer[] qty = new Integer[1024];
    private Double[] totalPrice = new Double[1024];
    private List<SeslesReport> sre1 = new ArrayList<>();
    private List<SeslesReport> slsList11 = new ArrayList<>();
    private double gtotal;
    private double gtota2;
    private int memo;
    private String date;
    public SalesBean() {
        productList = mb.purductName();
        
    }

    public void memoFindview() {
        Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("select * from sales where MemoNo=?");
            stm.setInt(1, 4);
            ResultSet rs = stm.executeQuery();
            double gt = 0.0;
            while (rs.next()) {
                gt += rs.getDouble(6);
                setDate(rs.getString(7));
                slsList11.add(new SeslesReport(rs.getInt(8), rs.getInt(2), rs.getString(3), rs.getInt(5), rs.getDouble(6), rs.getDate(7), rs.getInt(9)));
                System.out.println(rs.getDouble("Total"));
            }
            setGtota2(gt);    
            con.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public void test(){
        for(SeslesReport p:slsList11){
            System.out.println(p.getProName());
        }
    }
    public static void main(String[] args) {
        SalesBean ss=new SalesBean();
        ss.test();
    }

    public void reportFirstModel(HttpServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession ses = req.getSession(false);
        int emp_id = (Integer.parseInt(ses.getAttribute("status").toString()));
        Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("SELECT distinct MemoNo,sum(Price*Quantity) as GT FROM sales where Sell_Date=DATE_FORMAT(NOW(),'%Y-%m-%d') and Emp_Id=? group by MemoNo");
            stm.setInt(1, emp_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sre1.add(new SeslesReport(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (Exception e) {
        }

    }

    public void doSave(HttpServletRequest request) {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession ses = req.getSession(false);
            String emp_id = ses.getAttribute("status").toString();
            Integer memoNo = new SalesDao().lastMemo();
            int aa = 0;
            for (String p : selectedPoduct) {
                for (ModelProduct p1 : modelPurForm) {
                    if (p1.getPro_Name().equalsIgnoreCase(p)) {
                        Session s = HibernateUtil.getSessionFactory().openSession();
                        s.beginTransaction();
                        pro.setProId(p1.getPro_Id());
                        pur.setProduct(pro);
                        emp.setEmpId(Integer.parseInt(emp_id));
                        pur.setEmployee(emp);
                        pur.setProName(p1.getPro_Name());
                        pur.setPrice(new SalesDao().findprice(p1.getPro_Id()));
                        pur.setQuantity(qty[p1.getPro_Id()]);
                        pur.setTotal(totalPrice[p1.getPro_Id()]);
                        pur.setSellDate(new Date());
                        pur.setMemoNo(memoNo);
                        Serializable a = s.save(pur);
                        s.getTransaction().commit();
                        s.close();
                        aa = (int) a;

                    }
                }
            }
            if (aa > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Saved"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Fail!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        }

    }

    public void cTotalPrice(int c) {
        Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("select Sales_Price from prices where Id=" + c + " ");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                totalPrice[c] = rs.getDouble(1) * qty[c];
                gtotal += totalPrice[c];
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createPurForm() {
        modelPurForm.clear();
        Connection con = null;
        PreparedStatement stm = null;
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

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

    public Set<String> getSelectedPoduct() {
        return selectedPoduct;
    }

    public void setSelectedPoduct(Set<String> selectedPoduct) {
        this.selectedPoduct = selectedPoduct;
    }

    public Set<ModelProduct> getModelPurForm() {
        return modelPurForm;
    }

    public void setModelPurForm(Set<ModelProduct> modelPurForm) {
        this.modelPurForm = modelPurForm;
    }

    public SalesDao getMb() {
        return mb;
    }

    public void setMb(SalesDao mb) {
        this.mb = mb;
    }

    public ModelPurchases getmPur() {
        return mPur;
    }

    public void setmPur(ModelPurchases mPur) {
        this.mPur = mPur;
    }

    public Sales getPur() {
        return pur;
    }

    public void setPur(Sales pur) {
        this.pur = pur;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public List<SeslesReport> getSre1() {
        return sre1;
    }

    public void setSre1(List<SeslesReport> sre1) {
        this.sre1 = sre1;
    }

    public int getMemo() {
        return memo;
    }

    public void setMemo(int memo) {
        this.memo = memo;
    }

   

    public double getGtota2() {
        return gtota2;
    }

    public void setGtota2(double gtota2) {
        this.gtota2 = gtota2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public SeslesReport getSreport() {
        return sreport;
    }

    public void setSreport(SeslesReport sreport) {
        this.sreport = sreport;
    }

    public List<SeslesReport> getSlsList11() {
        return slsList11;
    }

    public void setSlsList11(List<SeslesReport> slsList11) {
        this.slsList11 = slsList11;
    }

}
