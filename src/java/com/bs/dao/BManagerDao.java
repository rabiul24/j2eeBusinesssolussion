/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.BManagerModel;
import com.bs.pojo.BManager;
import com.bs.pojo.Employee;
import com.bs.pojo.Product;
import com.bs.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 *
 * @author use
 */
@Service
public class BManagerDao implements BManagerModel {

    @Override
    public boolean doInsertBManager(BManager bManager) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(bManager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doUpdateBManager(BManager bManager) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(bManager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doDeleteBManager(BManager bManager) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(bManager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public List<BManager> findAllBManager() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From BManager");
            List<BManager> bList = q.list();

            s.getTransaction().commit();
            return bList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

    @Override
    public List<BManager> findByBManagerId(int bmId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From BManager where bmId=" + bmId + "");
            List<BManager> bList = q.list();
            s.getTransaction().commit();
            return bList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Integer> findAllEmployeeId() {
         Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("Select empId From Employee where desgination='BM'");
            List<Integer> bList = q.list();
            s.getTransaction().commit();
            return bList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

    @Override
    public List<String> findAllEmployeeNameById(int empId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("SELECT empName From Employee where empId=" + empId + "");
            List<String> bList = q.list();
            s.getTransaction().commit();
            return bList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }


}
