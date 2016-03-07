package BusinessLogic.Controller;

import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Product;


public class HandleProduct {

    public String createProduct(String name, String type, String desc, String category) {
        
        Product product = new Product();
        product.setNsname(name);
        product.setNstype(type);
        product.setNsdescription(desc);
        product.setNscategory(category);
        
        ProductDAO dao = new ProductDAO();
        
        if (dao.persist(product)!= null) {
            return "El producto ha sido creado";
        } else {
            return "El producto no pudo ser creado.";
        }   
   
       
    }
    
}
