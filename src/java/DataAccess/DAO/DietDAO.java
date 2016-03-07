/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Diet;
import DataAccess.Entity.User;
import java.util.ArrayList;
import java.util.List;
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

    public synchronized boolean dietExists(String dietName) {
        EntityManager em = factory.createEntityManager();
        Diet diet = null;

        try {
            Query q = em.createNamedQuery("Diet.findByNsname");
            q.setParameter(1, dietName);
            diet = (Diet) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return diet != null;
        }
    }

    public List<Diet> fetchDiets() {
        EntityManager em = factory.createEntityManager();
        List<Diet> list = new ArrayList<>();

        try {
            Query q = em.createNamedQuery("Diet.findAll");
            list = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }

    public boolean assignDiet(Integer userid, int dietId) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("insert into user_diets (nsdietid,nsuserid) values (?1,?2)").
                    setParameter(1, dietId).setParameter(2, userid);
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo guardar la dieta asignada");
            em.close();
            return false;
        }
    }

    public List<Integer> getUserDiets(int userid) {
        EntityManager em = factory.createEntityManager();
        List<Integer> list = new ArrayList<>();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("select d.nsdietid from user_diets d where d.nsuserid = ?1").
                    setParameter(1, userid);

            list = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }

}
