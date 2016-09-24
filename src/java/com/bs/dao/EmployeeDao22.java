///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bs.dao;
//
//import com.bs.model.EmployeeModlel;
//import com.bs.pojo.Employee;
//import com.bs.util.HibernateUtil;
//import java.util.Date;
//import org.hibernate.Session;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Farid
// */
//@Service
//public class EmployeeDao22 implements EmployeeModlel {
//
//    @Override
//    public boolean doInsert(String name, String email, String mobile , String desig,String phone ,Date date) {
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        try {
//            s.beginTransaction();
//            Employee emp=new Employee(name, email, mobile, desig, phone, date);
//            s.save(emp);
//            s.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//
//        } finally {
//            s.close();
//        }
//    }
//}
