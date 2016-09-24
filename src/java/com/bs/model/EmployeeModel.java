/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Employee;
import java.util.Date;
import java.util.List;

public interface EmployeeModel {
    public boolean doInsertEmployee(Employee employee);
    public boolean doUpdateEmployee(Employee employee);
    public boolean doDeleteEmployee(Employee employee);
    public List<Employee> findAllEmployee();
    public List<Employee> findByEmployee(int empId);
    
    
}
