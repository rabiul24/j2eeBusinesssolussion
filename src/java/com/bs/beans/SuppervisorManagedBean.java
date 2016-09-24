/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;


import com.bs.dao.SuppervisorDao;
import com.bs.pojo.Employee;
import com.bs.pojo.Location;
import com.bs.pojo.Manager;
import com.bs.pojo.Suppervisor;
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
@ManagedBean(name ="spv")
@RequestScoped
public class SuppervisorManagedBean {
     public SuppervisorManagedBean() {
      doViewAllSuppervisor();
    }

    
 

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/suppervisor.xml");
    private Suppervisor suppervisor = (Suppervisor) ctx.getBean("suppervisor");
    private Employee employee = (Employee) ctx.getBean("employee");
    private Manager  manager  = (Manager) ctx.getBean("manager");
    private Location location = (Location) ctx.getBean("location");
    
    SuppervisorDao suppervisorDao = (SuppervisorDao) ctx.getBean("suppervisorDao");
    private List<Suppervisor> suppervisorAllList = new ArrayList<>();
    //not working in this moment.
    private List<Suppervisor> suppervisorListById = new ArrayList<>();

   
    @Autowired
    public void saveSuppervisor() {
        suppervisor.setEmployee(employee);
        suppervisor.setManager(manager);
        suppervisor.setLocation(location);
    
        boolean r = suppervisorDao.doInsertSuppervisor(suppervisor);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void deleteSuppervisor() {
         suppervisor.setEmployee(employee);
        suppervisor.setManager(manager);
        suppervisor.setLocation(location);
        boolean r = suppervisorDao.doDeleteSuppervisor(suppervisor);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void updateSuppervisor() {
         suppervisor.setEmployee(employee);
        suppervisor.setManager(manager);
        suppervisor.setLocation(location);
        boolean r = suppervisorDao.doUpdateSuppervisor(suppervisor);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doViewAllSuppervisor() {
     suppervisorAllList=suppervisorDao.findAllSuppervisor();   
    }

    @Autowired
   
    public void findAllSuppervisorById() {
         suppervisor.setEmployee(employee);
        suppervisor.setManager(manager);
        suppervisor.setLocation(location);
        suppervisorListById = suppervisorDao.findSuppervisorById(suppervisor.getSupId());
       
        for(Suppervisor sp : suppervisorListById) {
            suppervisor.setSupName(sp.getSupName());
           
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Suppervisor getSuppervisor() {
        return suppervisor;
    }

    public void setSuppervisor(Suppervisor suppervisor) {
        this.suppervisor = suppervisor;
    }

    public List<Suppervisor> getSuppervisorAllList() {
        return suppervisorAllList;
    }

    public void setSuppervisorAllList(List<Suppervisor> suppervisorAllList) {
        this.suppervisorAllList = suppervisorAllList;
    }

    public List<Suppervisor> getSuppervisorListById() {
        return suppervisorListById;
    }

    public void setSuppervisorListById(List<Suppervisor> suppervisorListById) {
        this.suppervisorListById = suppervisorListById;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    

}
