/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class IndexBean implements Serializable {

    private static boolean isLoggedIn = false;
    private static boolean displayAdminPanel;
    private static boolean displayNutritionistPanel;
    private static boolean displayClientPanel;

    public boolean isIsLoggedIn() {
        setIsLoggedIn(SessionBean.userHasSession());
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean display) {
        isLoggedIn = display;
    }

    public boolean isDisplayAdminPanel() {

//        return checkIfUserIsLoggedIn() && parseInteger(SessionBean.getAttribute(SessionBean.userRoleAtribute))
//                == UserRole.admin.ordinal();
        return displayAdminPanel;
    }

    public static void setDisplayAdminPanel(boolean display) {
//        boolean show = SessionBean.getAttribute(SessionBean.userRoleAtribute) == 
        displayAdminPanel = display;
    }

    public static boolean isDisplayNutritionistPanel() {
//        return checkIfUserIsLoggedIn() && parseInteger(SessionBean.getAttribute(SessionBean.userRoleAtribute))
//                == UserRole.nutritionist.ordinal();
        return displayNutritionistPanel;
    }

    public static void setDisplayNutritionistPanel(boolean display) {
        displayNutritionistPanel = display;
    }

    public static boolean isDisplayClientPanel() {
//        return checkIfUserIsLoggedIn() && parseInteger(SessionBean.getAttribute(SessionBean.userRoleAtribute))
//                == UserRole.client.ordinal();
        return displayClientPanel;
    }

    public static void setDisplayClientPanel(boolean display) {
        displayClientPanel = display;
    }

    public String doLogout() {
        SessionBean.finalizeSession();
        updateViews(false);
        return "index";
    }

    public static void updateViews(boolean isLoggedIn) {
        setIsLoggedIn(isLoggedIn);
        int activeRole = -1;
        try {
            if (isLoggedIn) {
                activeRole = parseInteger(SessionBean.getAttribute(SessionBean.userRoleAtribute));
            }
        } catch (Exception e) {
        }
        setDisplayAdminPanel(activeRole == UserRole.admin.ordinal());
        setDisplayNutritionistPanel(activeRole == UserRole.nutritionist.ordinal());
        setDisplayClientPanel(activeRole == UserRole.client.ordinal());
    }

    private synchronized static int parseInteger(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return -1;
        }
    }

    private boolean checkIfUserIsLoggedIn() {
        return SessionBean.userHasSession();
    }

    public static enum UserRole {
        admin, nutritionist, client;
    }

}
