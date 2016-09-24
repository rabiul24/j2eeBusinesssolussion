/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Address;
import com.bs.pojo.Salary;
import java.util.List;

public interface SalaryModel {
    public boolean doInsertSalary(Salary salary);
    public boolean doUpdateSalary(Salary salary);
    public boolean doDeleteSalary(Salary salary);
    public List<Salary> findAllSalary();
    public List<Salary> findSalaryById(int salaryId);
    
    
}
