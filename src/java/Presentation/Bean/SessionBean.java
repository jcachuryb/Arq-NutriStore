/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;


import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean {

    public static boolean addSession() {
        String sessionid = getSession().getId();
        if (sessionHash.isEmpty() || !sessionHash.containsKey(sessionid)) {
            sessionHash.put(sessionid, getSession());
            System.out.println("New Session added");
            return true;
        }
        return false;
    }

    private static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public synchronized static boolean userHasSession() {
        try {
            String sessionid = getSession().getId();
            return sessionHash.containsKey(sessionid);
        } catch (Exception e) {
            return false;
        }
    }

    public static HttpSession getUserSession() {
        String sessionid = getSession().getId();
        try {
            return sessionHash.get(sessionid);
        } catch (Exception e) {
            return null;
        }

    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getAttribute(String attribute) {
        try {
            HttpSession session = getSession();
            return session.getAttribute(attribute).toString();
        } catch (Exception e) {
            return "";
        }

    }

    public synchronized static boolean finalizeSession() {
        String sessionid = getSession().getId();

        try {
            sessionHash.remove(sessionid);
            System.out.println("Session finalized");

            return true;
        } catch (Exception e) {
            System.out.println("Session could not be finalized");
            return false;
        }
    }

    private static HashMap<String, HttpSession> sessionHash = new HashMap<>();
    public final static String userNameAtribute = "user";
    public final static String userIdAtribute = "id";
    public final static String userRoleAtribute = "role";

        static boolean  validatePermission(int roleid) {
        if (getUserSession() != null) {
            return Integer.parseInt(getAttribute(userRoleAtribute)) == roleid;
        }
        return false;
    }
}
