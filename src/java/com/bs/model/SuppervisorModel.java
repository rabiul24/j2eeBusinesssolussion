/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Suppervisor;
import java.util.List;

public interface SuppervisorModel {
    public boolean doInsertSuppervisor(Suppervisor suppervisor);
    public boolean doUpdateSuppervisor(Suppervisor suppervisor);
    public boolean doDeleteSuppervisor(Suppervisor suppervisor);
    public List<Suppervisor> findAllSuppervisor();
    public List<Suppervisor> findSuppervisorById(int supId); 
}
