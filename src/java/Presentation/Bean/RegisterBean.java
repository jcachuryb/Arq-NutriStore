/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleUser;
import DataAccess.Entity.Role;
import DataAccess.Entity.User;
import Presentation.Bean.IndexBean.UserRole;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RegisterBean {

    private String name;
    private String passwordAccount;
    private String repeatPwd;
    private String message;
    private String document;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRepeatPwd() {
        return repeatPwd;
    }

    public void setRepeatPwd(String repeatPwd) {
        this.repeatPwd = repeatPwd;
    }

    public RegisterBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String createUser() {
        HandleUser hu = new HandleUser();
        String m = "";
        try {
            m = hu.register(name, passwordAccount, UserRole.client.ordinal(), Long.parseLong(getDocument()));
        } catch (Exception e) {
        }

        if ("Success".equals(m)) {
            return "login";
        } else {
            message = m;
            return "registro";
        }
    }

}
