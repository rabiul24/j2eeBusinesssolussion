/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.dao;

import com.bs.model.AddressModel;
import com.bs.pojo.Address;
import com.bs.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class AddressDao implements AddressModel {

    @Override
    public boolean doInsertAddress(Address address) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.save(address);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doUpdateAddress(Address address) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.update(address);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public boolean doDeleteAddress(Address address) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            s.delete(address);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        } finally {
            s.close();
        }
    }

    @Override
    public List<Address> findAllAddress() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Address");
            List<Address> aList = q.list();
            s.getTransaction().commit();
            return aList;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public List<Address> findAddressById(int addressId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("From Address  where addressId=" + addressId + "");
            List<Address> aList = q.list();
            s.getTransaction().commit();
            return aList;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }

    }
}
