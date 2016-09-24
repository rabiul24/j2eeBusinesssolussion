/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.loginBean;

import com.bs.beans.LoginUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;
    private String test;

    public LoginBean() {
    }

    @Autowired
    public String doLogincgeck() {
        String status = new LoginDao().checkLogin(username, password);
        if (status.toLowerCase().equalsIgnoreCase("bm") && status != null && status != "") {
            String bm=new LoginDao().findEmpId(username, password);
            HttpSession session = LoginUtil.getSession();
//            session.setAttribute("username", username);
            session.setAttribute("status", bm);
            return "bm";
        } else if (status.toLowerCase().equalsIgnoreCase("dataentry") && status != null && status != "") {
             String dataentry=new LoginDao().findEmpId(username, password);
            HttpSession session = LoginUtil.getSession();
//            session.setAttribute("username", username);
            session.setAttribute("status", dataentry);
            return "dataentry";
        } else if (status.toLowerCase().equalsIgnoreCase("user") && status != null && status != "") {
            String user=new LoginDao().findEmpId(username, password);
            HttpSession session = LoginUtil.getSession();
//            session.setAttribute("username", username);
                
            session.setAttribute("status", user);
            return "user";
        } else if (status.toLowerCase().equalsIgnoreCase("Exception") && status == null) {
            return "contact";
        } else {
            return "try";
        }
    }

    @Autowired
    public String logout() {
        HttpSession session = LoginUtil.getSession();
        session.invalidate();
        return "logout";
    }

    public String doLogout() {

        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
