/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;
import com.bs.pojo.Manager;
import java.util.List;

/**
 *
 * @author use
 */
public interface ManagerModel {
    public boolean doInsertManager(Manager manager);
    public boolean doUpdateManager(Manager manager);
    public boolean doDeleteManager(Manager manager);
    public List<Manager> findAllManager();
    public List<Manager> findByManagerId(int MId);
    public List<Integer> findAllEmployeeId();
    public List<String> findAllEmployeeNameById(int empId);
}
