/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.ManagerDao;
import com.bs.pojo.Employee;
import com.bs.pojo.Manager;
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
 * @author use
 */
@Component
@ManagedBean(name = "m")
@RequestScoped
public class ManagerManagedBean {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/manager.xml");
    private Manager manager = (Manager) ctx.getBean("manager");
    private Employee employee = (Employee) ctx.getBean("employee");
    ManagerDao managerDao = (ManagerDao) ctx.getBean("managerdao");
    private List<Manager> managerAllList = new ArrayList<>();
    private List<Manager> managerListById = new ArrayList<>();
    private List<Integer> allEmpId = new ArrayList<>();
    private List<String> employeelistbyid = new ArrayList<>();

    public ManagerManagedBean() {
        doViewAllManager();
    }

    @Autowired
    public void doInsertManager() {
        manager.setEmployee(employee);
        boolean r = managerDao.doInsertManager(manager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doUpdateManager() {
        manager.setEmployee(manager.getEmployee());
        boolean r = managerDao.doUpdateManager(manager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doDeleteManager() {
        manager.setEmployee(employee);
        boolean r = managerDao.doDeleteManager(manager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doViewAllManager() {
        managerAllList = managerDao.findAllManager();

    }
        @Autowired
    public void findByEmployeeId() {

        employeelistbyid = managerDao.findAllEmployeeNameById(employee.getEmpId());
        for (String e : employeelistbyid) {
                manager.setMName(e);
        }

    }

    @Autowired
    public void findAllManagerById() {
        manager.setEmployee(employee);
        managerListById = managerDao.findByManagerId(manager.getMId());
        for (Manager m : managerListById) {
            manager.setMName(m.getMName());
            manager.setEmployee(m.getEmployee());
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Manager> getManagerAllList() {
        return managerAllList;
    }

    public void setManagerAllList(List<Manager> managerAllList) {
        this.managerAllList = managerAllList;
    }

    public List<Manager> getManagerListById() {
        return managerListById;
    }

    public void setManagerListById(List<Manager> managerListById) {
        this.managerListById = managerListById;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Integer> getAllEmpId() {
        allEmpId = managerDao.findAllEmployeeId();
        return allEmpId;
    }

    public void setAllEmpId(List<Integer> allEmpId) {
        this.allEmpId = allEmpId;
    }

    public List<String> getEmployeelistbyid() {
        return employeelistbyid;
    }

    public void setEmployeelistbyid(List<String> employeelistbyid) {
        this.employeelistbyid = employeelistbyid;
    }

}
