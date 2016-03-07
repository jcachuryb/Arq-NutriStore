/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Diet;
import DataAccess.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DietDAO {

    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("NutriStorePU");

    public synchronized Diet persist(Diet diet) {
        factory.isOpen();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(diet);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("DAO EXCEPTION " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            factory.close();
            return diet;
        }
    }

 

}
