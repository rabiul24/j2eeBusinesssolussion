/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.loginBean;

import com.bs.database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Java Programmer
 */
public class LoginDao {

    public String checkLogin(String user, String pass) {
        Connection con = DB.getConnection();
        String r = null;
        try {
            PreparedStatement stm = con.prepareStatement("select ca.User_Role from login l, ctrl_access ca where l.Emp_Id=ca.Emp_Id and l.User_Name=? and l.password=? and ca.Status='active'");
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                r = rs.getString(1);
            } else {
                r = null;
            }
        } catch (SQLException ex) {
            r = "Exception";
        }
        return r;
    }
    public String findEmpId(String user, String pass){
         Connection con = DB.getConnection();
        String r = null;
        try {
            PreparedStatement stm = con.prepareStatement("SELECT Emp_Id FROM login where User_Name=? && password=?");
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                r = rs.getString(1);
            } else {
                r = null;
            }
        } catch (SQLException ex) {
           
        }
        return r;
    }
}
