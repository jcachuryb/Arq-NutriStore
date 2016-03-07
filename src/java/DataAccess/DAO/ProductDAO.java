/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Product;
import DataAccess.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
