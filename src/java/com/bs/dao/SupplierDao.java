/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.SupplierModel;
import com.bs.pojo.Location;
import com.bs.pojo.Supplier;
import com.bs.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class SupplierDao implements SupplierModel{

    @Override
    public boolean doInsertSupplier(Supplier supplier) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(supplier);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doUpdateSupplier(Supplier supplier) {
       Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(supplier);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doDeleteSupplier(Supplier supplier) {
         Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(supplier);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Supplier> findAllSupplier() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Supplier");
            List<Supplier> pList = q.list();
            s.getTransaction().commit();
            return pList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Supplier> findBySupplierId(int suppId) {
       Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Supplier where suppId="+suppId+"");
            List<Supplier> pList = q.list();
            s.getTransaction().commit();
            return pList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }
    
}
