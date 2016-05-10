/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.User;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO {

    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("NutriStorePU");

    public synchronized User persist(User user) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("DAO EXCEPTION " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return user;
        }
    }

    public synchronized User searchByUserID(Long userid) {

        EntityManager em = factory.createEntityManager();
        User user = null;

        try {
            user = em.find(User.class, userid);
        } catch (Exception e) {
        } finally {
            em.close();
            return user;
        }
    }

    public synchronized List<User> fetchByUserRole(Integer roleid) {

        EntityManager em = factory.createEntityManager();
        List<User> list = new ArrayList<>();
        
        
        try {
            Query q = em.createNamedQuery("User.findByIdrole");
            q.setParameter(1, roleid);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
        }
        
        return list;
    }

    public synchronized boolean userExists(String username) {
        EntityManager em = factory.createEntityManager();
        User user = null;

        try {
            Query q = em.createNamedQuery("User.findByUsername");
            q.setParameter(1, username);
            user = (User) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return user != null;
        }
    }

    public synchronized User doLogIn(String username, String password) {

        EntityManager em = factory.createEntityManager();
        User user = null;

        try {
            Query q = em.createNamedQuery("User.login");
            q.setParameter(1, username);
            q.setParameter(2, password);
            user = (User) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return user;
        }
    }

    public User getUserByUserName(String username) {
        EntityManager em = factory.createEntityManager();
        User user = null;

        try {
            Query q = em.createNamedQuery("User.findByUsername");
            q.setParameter(1, username);
            user = (User) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return user;
        }
    }
    
    public User getUserByDocument(long document) {
        EntityManager em = factory.createEntityManager();
        User user = null;

        try {
            Query q = em.createNamedQuery("User.findByDocument");
            q.setParameter(1, document);
            user = (User) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION JC " + e);
        } finally {
            em.close();
            return user;
        }
    }
}
