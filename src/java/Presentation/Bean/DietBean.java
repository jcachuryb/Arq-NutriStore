/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleDiet;
import DataAccess.Entity.Diet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DietBean {
    private String message;
    private String name;
    private String desc;

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
    
    public void addDiet(){
        HandleDiet handler = new HandleDiet();
        
        if (handler.createDiet(name, desc)) {
            message = "Dieta añadida con éxito";
        }else{
            message = "Error al guardar";
        }
        
        
    } 
    
    
}
