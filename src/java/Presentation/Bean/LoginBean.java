/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleUser;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String user;
    private String message;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String validateUsernamePassword() {
        HandleUser hu = new HandleUser();

        User mUser = hu.doLogin(user, pwd);

        boolean valid = mUser != null;
        if (valid) {
            boolean isNew = SessionBean.addSession();
            if (isNew) {
                HttpSession session = SessionBean.getUserSession();
                session.setAttribute(SessionBean.userNameAtribute, mUser.getUsername());
                session.setAttribute(SessionBean.userIdAtribute, mUser.getId());
                session.setAttribute(SessionBean.userRoleAtribute, mUser.getIdrole());
                userName = mUser.getUsername();
                IndexBean.updateViews(true);
                return "index";
            } else {
                message = "YA HABÍA INGRESADO!!";
                return "login";
            }
        } else {
            message = "Usuario o contraseña inválidos";
            return "login";
        }
    }

}
