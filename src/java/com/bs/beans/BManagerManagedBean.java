/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.BManagerDao;
import com.bs.pojo.BManager;
import com.bs.pojo.Employee;
import com.bs.pojo.Location;
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
@ManagedBean(name = "b")
@RequestScoped
public class BManagerManagedBean {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/bManager.xml");
    private BManager bmanager = (BManager) ctx.getBean("bmanager");
    private Employee employee = (Employee) ctx.getBean("employee");
    private Location location = (Location) ctx.getBean("location");
    BManagerDao bmanagerdao = (BManagerDao) ctx.getBean("bmanagerdao");
    private List<BManager> bmanagerallList = new ArrayList<>();
    private List<Integer> allEmpId = new ArrayList<>();
    private List<BManager> bmanagerlistbyid = new ArrayList<>();
    private List<String> employeelistbyid = new ArrayList<>();

    public BManagerManagedBean() {
        doViewAllBManager();
    }

    @Autowired
    public void doInsertBManager() {
        bmanager.setEmployee(employee);
        bmanager.setLocation(location);
        boolean r = bmanagerdao.doInsertBManager(bmanager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doUpdateBManager() {
        bmanager.setEmployee(employee);
        bmanager.setLocation(location);
        boolean r = bmanagerdao.doUpdateBManager(bmanager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doDeleteBManager() {
        bmanager.setEmployee(employee);
        bmanager.setLocation(location);
        boolean r = bmanagerdao.doDeleteBManager(bmanager);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doViewAllBManager() {
        bmanagerallList = bmanagerdao.findAllBManager();

    }

    @Autowired
    public void findByBManagerId() {

        bmanagerlistbyid = bmanagerdao.findByBManagerId(bmanager.getBmId());
        for (BManager b : bmanagerlistbyid) {
            bmanager.setBmName(b.getBmName());
            bmanager.setEmployee(b.getEmployee());
            bmanager.setLocation(b.getLocation());
        }

    }

    @Autowired
    public void findByEmployeeId() {

        employeelistbyid = bmanagerdao.findAllEmployeeNameById(employee.getEmpId());
        for (String e : employeelistbyid) {
                bmanager.setBmName(e);
        }

    }
    @Autowired
    public void checkEmployeeId() {
            if (employee.getEmpId().equals(allEmpId)) {
                addMessage("Valid Employee Id");
            }else{
               this.addMessage("Invalid employee Id."); 
            }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public BManager getBmanager() {
        return bmanager;
    }

    public void setBmanager(BManager bmanager) {
        this.bmanager = bmanager;
    }

    public List<BManager> getBmanagerallList() {
        return bmanagerallList;
    }

    public void setBmanagerallList(List<BManager> bmanagerallList) {
        this.bmanagerallList = bmanagerallList;
    }

    public List<BManager> getBmanagerlistbyid() {
        return bmanagerlistbyid;
    }

    public void setBmanagerlistbyid(List<BManager> bmanagerlistbyid) {
        this.bmanagerlistbyid = bmanagerlistbyid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Integer> getAllEmpId() {
        allEmpId = bmanagerdao.findAllEmployeeId();
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
