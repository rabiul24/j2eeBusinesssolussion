/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.AttendanceModel;
import com.bs.pojo.Attendance;
import com.bs.pojo.Employee;
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
public class AttendanceDao implements AttendanceModel {

    @Override
    public boolean doInsertAttendance(Attendance attendance) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(attendance);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doUpdateAttendance(Attendance attendance) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(attendance);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doDeleteAttendance(Attendance attendance) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(attendance);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Attendance> findAllAttendance() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Attendance");
            List<Attendance> aList = q.list();

            s.getTransaction().commit();
            return aList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }
    public List<Employee> findAllEmployee() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Employee");
            List<Employee> eList = q.list();
            s.getTransaction().commit();
            return eList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }
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
    public List<Attendance> findByAttendanceId(int AId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Attendance where AId=" + AId + "");
            List<Attendance> aList = q.list();
            s.getTransaction().commit();
            return aList;
        } catch (Exception e) {
            return null;

        } finally {
            s.close();
        }
    }

}
