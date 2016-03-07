/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Diet;
import DataAccess.Entity.Product;
import DataAccess.Entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductDAO {

    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("NutriStorePU");

    public synchronized Product persist(Product product) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("DAO EXCEPTION " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return product;
        }
    }

    public synchronized boolean productExists(String productName) {
        EntityManager em = factory.createEntityManager();
        Product product = null;

        try {
            Query q = em.createNamedQuery("Product.findByNsname");
            q.setParameter(1, productName);
            product = (Product) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return product != null;
        }
    }

    public List<Product> fetchProducts() {
        EntityManager em = factory.createEntityManager();
        List<Product> list = new ArrayList<>();

        try {
            Query q = em.createNamedQuery("Product.findAll");
            list = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }
}
