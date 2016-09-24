/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.model;

import com.bs.pojo.Location;
import java.util.List;

/**
 *
 * @author User
 */
public interface LocationModel {
    public boolean doInsertLocation(Location location);
    public boolean doUpdateLocation(Location location);
    public boolean doDeleteLocation(Location location);
    public List<Location> findAllLocation();
    public List<Location> findByLocationId(int locId);
}
