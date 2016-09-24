/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.database.*;
import com.bs.model.*;
import com.bs.modelPojo.*;
import com.bs.pojo.Purchases;
import com.bs.util.HibernateUtil;
import java.sql.*;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class PurchasesDao implements PurchasesModel {

    @Override
    public List<ModelProduct> purductName() {
        Connection con = null;
        PreparedStatement stm = null;
        List<ModelProduct> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            con = DB.getConnection();
            String sql = "SELECT Pro_Id, Pro_Name FROM product;";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new ModelProduct(rs.getInt(1), rs.getString(2)));
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
    public boolean doInsert(Purchases pur) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(pur);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
