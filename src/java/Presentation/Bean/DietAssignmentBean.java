/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleDiet;
import DataAccess.Entity.Diet;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DietAssignmentBean {

    private String message = "";
    private String username = "";
    private int dietId;
    private Map<Integer, String> diets;

    public void assignDiet() {
        HandleDiet handler = new HandleDiet();
        message = handler.assignDiet(username,dietId);
    }

    @PostConstruct
    public void init() {
        
        SessionBean.validatePermission(IndexBean.UserRole.nutritionist.ordinal());
        diets = new LinkedHashMap<>();
        loadDiets();
    }

    public void loadDiets() {
        HandleDiet handler = new HandleDiet();
        diets = new LinkedHashMap<>();
        handler.mapDiets(diets);

    }

    public String getMessage() {
        return message;
    }

    public Map<Integer, String> getDiets() {
        return diets;
    }

    public void setDiets(Map<Integer, String> diets) {
        this.diets = diets;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

}
