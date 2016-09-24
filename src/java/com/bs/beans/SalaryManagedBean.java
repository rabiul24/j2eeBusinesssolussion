/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.SalaryDao;
import com.bs.pojo.Employee;
import com.bs.pojo.Salary;
import com.bs.pojo.Sr;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Farid
 */
@Component
@ManagedBean(name ="sla")
@RequestScoped
public class SalaryManagedBean {
    
     public SalaryManagedBean() {
      doViewAllSalary();
    }


    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/salary.xml");
    private Salary salary = (Salary) ctx.getBean("salary");
    private Employee employee = (Employee) ctx.getBean("employee");
      private Sr sr = (Sr) ctx.getBean("sr");

    
    SalaryDao salaryDao = (SalaryDao) ctx.getBean("salaryDao");
    private List<Salary> salaryAllList = new ArrayList<>();  
    //not working in this moment.
    private List<Salary> salaryListById = new ArrayList<>();
   private List<Employee> elist=new ArrayList<>();
   
    @Autowired
    public void doSaveSalary() {
        salary.setSr(sr);
        salary.setEmployee(employee);
    
        boolean r = salaryDao.doInsertSalary(salary);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void deleteSalary() {
           salary.setSr(sr);
        salary.setEmployee(employee);
         
        boolean r = salaryDao.doDeleteSalary(salary);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void updateSalary() {
            salary.setSr(sr);
        salary.setEmployee(employee);
       
        boolean r = salaryDao.doUpdateSalary(salary);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doViewAllSalary() {
      
     salaryAllList=salaryDao.findAllSalary();   
    }

    @Autowired
    public void findAllSalaryById() {
        salary.setSr(sr);
        salary.setEmployee(employee);
  
        salaryListById = salaryDao.findSalaryById(salary.getSalaryId());
        for(Salary s : salaryListById) {
         salary.setSalaryId(s.getSalaryId());
         salary.setEmpName(s.getEmpName());
         salary.setBasicSalary(s.getBasicSalary());
         salary.setTarget(s.getTarget());
         salary.setTaDa(s.getTaDa());
        
         

           
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Employee> getElist() {
        return elist;
    }

    public void setElist(List<Employee> elist) {
        this.elist = elist;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Salary> getSalaryAllList() {
        return salaryAllList;
    }

    public void setSalaryAllList(List<Salary> salaryAllList) {
        this.salaryAllList = salaryAllList;
    }

    public List<Salary> getSalaryListById() {
        return salaryListById;
    }

    public void setSalaryListById(List<Salary> salaryListById) {
        this.salaryListById = salaryListById;
    }

    public Sr getSr() {
        return sr;
    }

    public void setSr(Sr sr) {
        this.sr = sr;
    }

}
