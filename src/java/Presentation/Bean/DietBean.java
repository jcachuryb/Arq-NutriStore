/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleDiet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DietBean {
    private String message;
    private String name;
    private String desc;
    private List<Integer> productList;
    
    
    @PostConstruct
    public void init() {
        SessionBean.validatePermission(IndexBean.UserRole.nutritionist.ordinal());
        productList = new ArrayList<>();
        message = "";
        name = "";
        desc = "";
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public void addProduct(int id){
        if (!productList.contains(id)) {
            productList.add(id);
        }
    }
    
    public void removeProduct(int id){
        if (productList.contains(id)) {
            productList.remove(id);
        }
    }
    
    public void addDiet(){
        HandleDiet handler = new HandleDiet();
        message = handler.createDiet(name, desc, productList);
    } 
    
    
}
