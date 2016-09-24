package com.bs.dao;

import com.bs.database.DB;
import com.bs.model.SalesModel;
import com.bs.modelPojo.ModelProduct;
import com.bs.modelPojo.SeslesReport;
import com.bs.pojo.Purchases;
import com.bs.pojo.Sales;
import com.bs.util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class SalesDao implements SalesModel {

    private final static String[] PRODUCTNAME = {"NCAFE", "NIDO", "Cerelac", "BFCP", "Kitkat", "Horlicks", "DCM", "printer", "Monitor", "aram", "tcpa", "Sprite", "Coca", "Mrnda", "Clemon"};

    @Override
    public List<Sales> findAll(Sales sales) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Sales");
            List<Sales> sal = q.list();
            s.close();
            return sal;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ModelProduct> purductName() {
        Connection con = null;
        PreparedStatement stm = null;
        List<ModelProduct> list = new ArrayList<ModelProduct>();
        ResultSet rs = null;
        try {
            con = DB.getConnection();
            String sql = "SELECT Pro_Id, Pro_Name FROM product;";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int c = 0;
            while (rs.next()) {
                list.add(new ModelProduct(rs.getInt(1), PRODUCTNAME[c].toUpperCase()));
                c++;
            }

        } catch (Exception e) {
        } finally {
            return list;
        }
    }

    @Override
    public void createPurForm() {

    }

    public boolean doInsCheck(java.util.Date d, String sn) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Purchases where purchasesDate=:da and serialNo=:sn");
            q.setParameter("da", d);
            q.setParameter("sn", sn);
            List li = q.list();

            if (li.size() > 0) {
                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    @Override
    public boolean doInsert(Sales sales) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(sales);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Double findprice(int id) {
        Double dd = 0.0;
        Connection con = DB.getConnection();
        PreparedStatement stm;
        try {
            stm = con.prepareStatement("Select Sales_Price from prices where Prices_Id=?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                dd = rs.getDouble(1);
            } else {
                dd = 0.0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dd;

    }

    public Integer lastMemo() {
        Integer dd = 0;
        Connection con = DB.getConnection();
        PreparedStatement stm;
        try {
            stm = con.prepareStatement("SELECT max(MemoNo)+1 FROM sales;");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                dd = rs.getInt(1);
            } else {

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dd;
    }

    public List<Sales> createModelReport() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Sales");
            List<Sales> li = q.list();
            return li;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }

    }
   
}
