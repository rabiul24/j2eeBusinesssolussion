/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.validations;

import com.bs.pojo.Employee;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Farid
 */
@ManagedBean
public class EmailValidator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public String emailValid() {
        Employee em = new Employee();
        if (em.getEmpName().matches(EMAIL_PATTERN)) {

        }
        return "invalid Email";
    }
}
