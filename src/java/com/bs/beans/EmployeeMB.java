///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bs.beans;
//
//import com.bs.dao.EmployeeDao22;
//import com.bs.pojo.Employee;
//import java.util.Date;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author Farid
// */
//@Component
//@ManagedBean
//@RequestScoped
//public class EmployeeMB{
//
//    private ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/employee.xml"); 
//    private Employee em3 = (Employee) ctx.getBean("emp11");
//   @NotNull 
//    private String ename;
//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "invalid email")
//    private String email;   
//    @Size(min = 11, max = 11, message = "Valid mobile number.")
//    private String mobile;    
//    private String designation;
//    private String phone;
//    @Past(message = "select past date.")
//    private Date date;
//    
//     public EmployeeMB() {
//         
//    }
//     public String doInsert(){
//         EmployeeDao22 dao=new EmployeeDao22();
//         em3.setEmpName(ename);
//         
//         boolean r=dao.doInsert(ename, email, mobile, email, phone, date);
//         return null;
//     }
//    public String addEmployee() {
//        
//        return null;
//    }
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//    
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//    public Employee getEm3() {
//        return em3;
//    }
//
//    public void setEm3(Employee em3) {
//        this.em3 = em3;
//    }
//   
//   
//    public String getEname() {
//        return ename;
//    }
//
//    public void setEname(String ename) {
//        this.ename = ename;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//   
//    
//    
//
//}
