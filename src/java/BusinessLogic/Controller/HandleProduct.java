package BusinessLogic.Controller;

import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Product;
import java.util.List;


public class HandleProduct {

    public String createProduct(String name, String type, String desc, String category) {
        ProductDAO dao = new ProductDAO();
        if (dao.productExists(name)) {
            return "El producto ya existe";
        }
        Product product = new Product();
        product.setNsname(name);
        product.setNstype(type);
        product.setNsdescription(desc);
        product.setNscategory(category);
        
        
        
        if (dao.persist(product)!= null) {
            return "El producto ha sido creado";
        } else {
            return "El producto no pudo ser creado.";
        }   
   
       
    }

    public List<Product> loadProducts() {
        ProductDAO dao = new ProductDAO();
        return dao.fetchProducts();
    }
    
}
