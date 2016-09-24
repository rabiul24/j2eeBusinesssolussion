/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.BManager;
import com.bs.pojo.Employee;
import java.util.List;

public interface BManagerModel {
    public boolean doInsertBManager(BManager bManager);
    public boolean doUpdateBManager(BManager bManager);
    public boolean doDeleteBManager(BManager bManager);
    public List<BManager> findAllBManager();
    public List<BManager> findByBManagerId(int bmId);
    public List<Integer> findAllEmployeeId();
    public List<String> findAllEmployeeNameById(int empId);
    
}
