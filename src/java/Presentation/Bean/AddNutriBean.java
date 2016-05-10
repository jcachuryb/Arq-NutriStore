/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleUser;
import DataAccess.Entity.User;
import Presentation.Bean.IndexBean.UserRole;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AddNutriBean {
    
    private String name;
    private String passwordAccount;
    private String repeatPwd;
    private String message;
    private String document;
    
    private List<User> userList = new ArrayList<User>();
    
    @PostConstruct
    public void init() {
        onLoad();
    }
    
    public String onLoad() {
        if (SessionBean.validatePermission(IndexBean.UserRole.admin.ordinal())) {
            resetPage();
            updateUserList();
            return "";
        }
        return "index";
    }
    
    public void resetPage() {
        name = "";
        passwordAccount = "";
        repeatPwd = "";
        message = "";
    }
    
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
    
    public AddNutriBean() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDocument() {
        return document;
    }
    
    public void setDocument(String document) {
        this.document = document;
    }
    
    public String getPasswordAccount() {
        return passwordAccount;
    }
    
    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }
    
    public List<User> getUserList() {
        return userList;
    }
    
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public String createUser() {
        if (!validatePasswords()) {
            message = "Las contraseñas no coinciden.";
            return "";
        }
        HandleUser hu = new HandleUser();
         String m = "";
         try {
            m = hu.register(name, passwordAccount, UserRole.nutritionist.ordinal(), Long.parseLong(getDocument()));
        } catch (Exception e) {
        }
        
        if ("Success".equals(m)) {
            message = "Se ha creado al nutricionista con nombre de usuario: " + name;
            updateUserList();
            return "";
        } else {
            message = "Ha ocurrido un error al guardar los datos.";
            return "";
        }
    }
    
    public void updateUserList() {
        HandleUser handleUser = new HandleUser();
        userList = handleUser.getUsersByRole(UserRole.nutritionist);
    }
    
    public boolean validatePasswords() {
        return passwordAccount.equals(repeatPwd);
    }
    
}
