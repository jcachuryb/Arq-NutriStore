/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import Presentation.Bean.IndexBean.UserRole;
import java.util.List;

public class HandleUser {
    public User doLogin(String username, String password) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.doLogIn(username, password);
        if (user != null) {
            return user;
        }

        return null;
    }

    public String register(String name, String passwordAccount, int roleid) {
        User mUser = new User();
        UserDAO userDAO = new UserDAO();

        mUser.setUsername(name);
        mUser.setPassword(passwordAccount);
        mUser.setIdrole(roleid);
        if (userDAO.userExists(mUser.getUsername())) {
            return "El nombre de usuario ya existe.";
        } else {
            userDAO.persist(mUser);
            return "Success";
        }
    }
    
     public List<User> getUsersByRole(UserRole role ){
         UserDAO userDAO = new UserDAO();
        return userDAO.fetchByUserRole(role.ordinal());
    }  
}
