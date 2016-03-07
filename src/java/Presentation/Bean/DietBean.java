/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleDiet;
import BusinessLogic.Controller.HandleProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DietBean {

    private String message;
    private String name;
    private String desc;
    private List<String> selectedProductList;
    private Map<Integer, String> products;

    @PostConstruct
    public void init() {
        onLoad();
    }

    public String onLoad() {
        if (SessionBean.validatePermission(IndexBean.UserRole.nutritionist.ordinal())) {
            resetPage();
            loadProducts();
            return "";
        }
        return "index";
    }

    public void resetPage(){
        message = "";
        name = "";
        desc = "";
        selectedProductList = new ArrayList<>();
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

    public List<String> getSelectedProductList() {
        return selectedProductList;
    }

    public void setSelectedProductList(List<String> selectedProductList) {
        this.selectedProductList = selectedProductList;
    }

    public Map<Integer, String> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, String> products) {
        this.products = products;
    }

    public void loadProducts() {
        HandleProduct handler = new HandleProduct();
        products = handler.mapProducts();
    }

    public void addDiet() {
        HandleDiet handler = new HandleDiet();
        message = handler.createDiet(name, desc, selectedProductList);
    }

}
