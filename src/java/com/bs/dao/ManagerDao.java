/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.ManagerModel;
import com.bs.pojo.Manager;
import com.bs.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 *
 * @author use
 */
@Service
public class ManagerDao implements ManagerModel{

    @Override
    public boolean doInsertManager(Manager manager) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(manager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doUpdateManager(Manager manager) {
         Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(manager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doDeleteManager(Manager manager) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(manager);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Manager> findAllManager() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Manager");
            List<Manager> mList = q.list();
            s.getTransaction().commit();
            return mList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Manager> findByManagerId(int MId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Manager where MId="+MId+"");
            List<Manager> mList = q.list();
            s.getTransaction().commit();
            return mList;
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
            Query q = s.createQuery("Select empId From Employee where desgination='Manager'");
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
