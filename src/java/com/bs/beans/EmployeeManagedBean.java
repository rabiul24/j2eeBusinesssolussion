/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.EmployeeDao;
import com.bs.pojo.Employee;
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
@ManagedBean(name ="e")
@RequestScoped
public class EmployeeManagedBean {
     public EmployeeManagedBean() {
      doViewAllEmployee();
    }

 
    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/employee.xml");
    private Employee employee = (Employee) ctx.getBean("employee");
    EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("employeedao");
    private List<Employee> employeeAllList = new ArrayList<>();
    //not working in this moment.
    private List<Employee> employeeListById = new ArrayList<>();

    @Autowired
    public void doSaveEmployee() {

       

        boolean r = employeeDao.doInsertEmployee(employee);
        
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void deleteEmployee() {
        boolean r = employeeDao.doDeleteEmployee(employee);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void updateEmployee() {
        boolean r = employeeDao.doUpdateEmployee(employee);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doViewAllEmployee() {
     employeeAllList=employeeDao.findAllEmployee();   
    }

    @Autowired
    public void findAllEmployeeById() {
        employeeListById = employeeDao.findByEmployee(employee.getEmpId());
        for(Employee e : employeeListById) {
            employee.setEmpName(e.getEmpName());
            employee.setEamil(e.getEamil());
            employee.setMobile(e.getMobile());
            employee.setDesgination(e.getDesgination());
            employee.setHireDate(e.getHireDate());
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployeeAllList() {
        return employeeAllList;
    }

    public void setEmployeeAllList(List<Employee> employeeAllList) {
        this.employeeAllList = employeeAllList;
    }

    public List<Employee> getEmployeeListById() {
        return employeeListById;
    }

    public void setEmployeeListById(List<Employee> employeeListById) {
        this.employeeListById = employeeListById;
    }

   
}
