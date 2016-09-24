/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;
import com.bs.dao.AttendanceDao;
import com.bs.pojo.Attendance;
import com.bs.pojo.Employee;
import com.bs.pojo.Manager;
import java.util.ArrayList;
import java.util.Date;
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
@ManagedBean(name = "atn")
@RequestScoped
public class AttendanceManagedBean {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bs/springConfigBean/attendance.xml");
    private Attendance attendance = (Attendance) ctx.getBean("attendance");
    AttendanceDao attendancedao = (AttendanceDao) ctx.getBean("attendanceDao");
    private List<Attendance> attendanceallList = new ArrayList<>();
    private List<Employee> employeeAllList = new ArrayList<>();
    private List<Manager> managerAllList = new ArrayList<>();
    private List<Attendance> attendancelistbyid = new ArrayList<>();

    public AttendanceManagedBean() {
        doViewAllAttendance();
        attendance.setDate(new Date());
        doViewAllManager();
        doViewAllEmployee();
    }

    @Autowired
    public void doInsertAttendance() {
        boolean r = attendancedao.doInsertAttendance(attendance);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doUpdateAttendance() {
        boolean r = attendancedao.doUpdateAttendance(attendance);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doDeleteAttendance() {
        boolean r = attendancedao.doDeleteAttendance(attendance);
        if (r) {
            addMessage("Success");
        } else {
            this.addMessage("Eroor please try again.");
        }
    }

    @Autowired
    public void doViewAllAttendance() {
        attendanceallList = attendancedao.findAllAttendance();
        
    }
    @Autowired
    public void doViewAllEmployee() {
       employeeAllList=attendancedao.findAllEmployee();
    }
    @Autowired
    public void doViewAllManager() {
        managerAllList = attendancedao.findAllManager();

    }

    @Autowired
    public void findByAttendance() {

        attendancelistbyid = attendancedao.findByAttendanceId(attendance.getAId());
        for (Attendance atn : attendancelistbyid) {
            attendance.setEmpName(atn.getEmpName());
        }

    }
    @Autowired
    public void checkStatus(){
        if(attendance.getStatus().equalsIgnoreCase("Present")){
            attendance.setPresent(1);
        }
        if(attendance.getStatus().equalsIgnoreCase("Absent")){
            attendance.setAbsent(1);
        }
        if(attendance.getStatus().equalsIgnoreCase("Late")){
            attendance.setLate(1);
        }
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }


    public List<Attendance> getAttendanceallList() {
        return attendanceallList;
    }

    public void setAttendanceallList(List<Attendance> attendanceallList) {
        this.attendanceallList = attendanceallList;
    }

    public List<Attendance> getAttendancelistbyid() {
        return attendancelistbyid;
    }

    public void setAttendancelistbyid(List<Attendance> attendancelistbyid) {
        this.attendancelistbyid = attendancelistbyid;
    }

    public List<Employee> getEmployeeAllList() {
        return employeeAllList;
    }

    public void setEmployeeAllList(List<Employee> employeeAllList) {
        this.employeeAllList = employeeAllList;
    }

    public List<Manager> getManagerAllList() {
        return managerAllList;
    }

    public void setManagerAllList(List<Manager> managerAllList) {
        this.managerAllList = managerAllList;
    }

}
