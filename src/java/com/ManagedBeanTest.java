/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.stereotype.Component;
@Component
@ManagedBean
@RequestScoped
public class ManagedBeanTest {
    private String name="farid";
    
    public String nameConcat(){
        name=getName()+" Ahmed";
        return "test.xhtml";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
