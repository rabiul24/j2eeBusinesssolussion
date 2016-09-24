/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.dao.LocationDao;
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
 * @author User
 */
@Component
@ManagedBean(name = "lo")
@RequestScoped
public class LocationManageBean {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/location.xml");
	
    private Location location = (Location) ctx.getBean("location");
    private Employee employee = (Employee) ctx.getBean("employee");
    LocationDao locationDao = (LocationDao) ctx.getBean("locationdao");

    private List<Location> locationListById = new ArrayList<>();
    private List<Location> locationAllList=new ArrayList<>();


    public LocationManageBean() {
        doViewAllLocation();
    }

    @Autowired
    public void doInsertLocation() {
        location.setEmployee(employee);
        boolean r = locationDao.doInsertLocation(location);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doUpdateLocation() {
        location.setEmployee(employee);
        boolean r = locationDao.doUpdateLocation(location);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doDeleteLocation() {
        location.setEmployee(employee);
        boolean r = locationDao.doDeleteLocation(location);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Error please try again.");
        }
    }

    @Autowired
    public void doViewAllLocation() {
        locationAllList = locationDao.findAllLocation();

    }

    @Autowired
    public void findAllLocationById() {
        locationListById = locationDao.findByLocationId(location.getLocId());
        for (Location lo : locationListById) {
            location.setLocName(lo.getLocName());
        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Location> getLocationAllList() {
        List<Location> locationAllList;
        return this.locationAllList;

    }

    public void setLocationAllList(List<Location> locationAllList) {
        this.locationAllList = locationAllList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
