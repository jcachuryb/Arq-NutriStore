/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleProduct;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AddProductBean {

    private String name = "";
    private String type = "";
    private String desc = "";
    private String category = "";
    private String message = "";
    private String data = "";

    public void resetPage() {
        name = "";
        type = "";
        desc = "";
        category = "";
        message = "";
        data = "";
    }

    @PostConstruct
    public void init() {
        onLoad();
    }

    public String onLoad() {
        if (SessionBean.validatePermission(IndexBean.UserRole.nutritionist.ordinal())) {
            resetPage();
            return "";
        }
        return "index";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public void addProduct() {
        HandleProduct hp = new HandleProduct();

        if ("Producto".equals(data)) {
            category = "Producto";
        } else {
            category = "Suplemento";
        }
        message = hp.createProduct(name, type, desc, category);
        data = "";
        category = "";

    }

}
