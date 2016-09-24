/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;
import com.bs.pojo.Attendance;
import com.bs.pojo.Employee;
import java.util.List;

/**
 *
 * @author use
 */
public interface AttendanceModel {
    public boolean doInsertAttendance(Attendance attendance);
    public boolean doUpdateAttendance(Attendance attendance);
    public boolean doDeleteAttendance(Attendance attendance);
    public List<Attendance> findAllAttendance();
    public List<Attendance> findByAttendanceId(int AId);
}
