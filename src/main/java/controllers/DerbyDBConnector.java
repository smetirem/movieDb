
package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DerbyDBConnector {

    private static final String PERSISTENCE_UNIT_NAME = "myMoviesPU";
    private static EntityManagerFactory movieDbFactory;
    private static EntityManager em;

    public static EntityManager createEntityManager() {
        if (movieDbFactory == null) {
            try {
                movieDbFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                DerbyDBConnector.em = movieDbFactory.createEntityManager();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return DerbyDBConnector.em;
    }

    public static void clearTable() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Movie").executeUpdate();
        em.createQuery("DELETE FROM Genre").executeUpdate();
       // em.createQuery("DELETE FROM FavoriteList").executeUpdate();
        em.getTransaction().commit();
    }

    public void persist(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
