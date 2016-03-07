/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.HandleProduct;
import DataAccess.Entity.Product;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProductViewerBean {
    private List<Product> list;

    @PostConstruct
    public void init() {
        updateProductList();
    }
    
    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    
    public void updateProductList(){
        HandleProduct handler = new HandleProduct();
        list = handler.loadProducts();
    }
}
