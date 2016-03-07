package BusinessLogic.Controller;

import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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

    public Map<Integer, String> mapProducts() {
        ProductDAO dao = new ProductDAO();
        Map<Integer, String> products = new LinkedHashMap<>();
        List<Product> list = dao.fetchProducts();
        for (Product product : list) {
            products.put(product.getId(), product.getNsname());
        }
        return products;
    }
    
}
