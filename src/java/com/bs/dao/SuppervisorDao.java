/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.EmployeeModel;
import com.bs.model.SuppervisorModel;
import com.bs.pojo.Employee;
import com.bs.pojo.Suppervisor;
import com.bs.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class SuppervisorDao implements  SuppervisorModel{


    @Override
    public boolean doInsertSuppervisor(Suppervisor suppervisor) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(suppervisor);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }   
        
    }

    @Override
    public boolean doUpdateSuppervisor(Suppervisor suppervisor) {
          Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(suppervisor);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        } 
    }

    @Override
    public boolean doDeleteSuppervisor(Suppervisor suppervisor) {
          Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(suppervisor);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        } 
    }

    @Override
    public List<Suppervisor> findAllSuppervisor() {
          Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Suppervisor");
            List<Suppervisor> spList = q.list();
            s.getTransaction().commit();
            return  spList;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public List<Suppervisor> findSuppervisorById(int supId) {
         Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Suppervisor where supId="+supId+"");
            List<Suppervisor> sList = q.list();
            s.getTransaction().commit();
            return sList;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

}
