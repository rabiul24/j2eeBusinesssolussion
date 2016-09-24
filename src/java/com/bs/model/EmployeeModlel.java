/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Employee;
import java.util.Date;

/**
 *
 * @author Farid
 */
public interface EmployeeModlel {
    public boolean doInsert(String name, String email, String mobile , String desig,String phone, Date date);
}
