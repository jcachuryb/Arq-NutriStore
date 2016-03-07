/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleDiet;
import DataAccess.Entity.Diet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DietsViewerBean {

    private List<Diet> list;

    public List<Diet> getList() {
        return list;
    }

    public void setList(List<Diet> list) {
        this.list = list;
    }

    public void updateDietsList() {
        HandleDiet handler = new HandleDiet();
        list = new ArrayList<>();
        if (SessionBean.getUserSession().getAttribute(SessionBean.userIdAtribute) != null) {
            int userid = Integer.parseInt(SessionBean.getUserSession().getAttribute(SessionBean.userIdAtribute).toString());
            int roleid = Integer.parseInt(
                    SessionBean.getUserSession().getAttribute(SessionBean.userRoleAtribute).toString());
            if (roleid == IndexBean.UserRole.client.ordinal()) {
                list = handler.loadUserDiets(userid);
            }
        }

    }

}
