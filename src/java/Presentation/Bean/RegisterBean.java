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

    public String createUser() {
        HandleUser hu = new HandleUser();

        String m = hu.register(name, passwordAccount, UserRole.client.ordinal());

        if (m == "Success") {
            return "index";
        } else {
            message = m;
            return "registro";
        }
    }

}
