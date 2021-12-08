
package controllers;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;


public class FavoriteList {
     public static List getAllFavoriteListsFromDerbyDb(EntityManager con){
        return con.createNamedQuery("FavoriteList.findAll").getResultList();
    }
     
         //Δημγουργία λίστας με όλες τις λίστες ταινιών της βάσης δεδομένων
    public List<models.FavoriteList> getAllLists(EntityManager con){
    return  con.createNamedQuery("FavoriteList.findAll").getResultList();
    }
    
    public static Object getFavoriteByName(EntityManager con, String name){
        Object test = con.createNamedQuery("FavoriteList.getListByName").setParameter("listName", name).getSingleResult();
        return con.createNamedQuery("FavoriteList.getListByName").setParameter("listName", name).getSingleResult();
    }
        
    //Ειαγωγή ταινίας σε λίστα   
    public void addMovieToAList(EntityManager con, models.Movie movie, models.FavoriteList list){ 
                list.getMovieCollection().add(movie);
                con.getTransaction().begin();
                con.persist(list);
                con.getTransaction().commit();
    }
    
    //Διαγραφή ταινίας από λίστα      
    public void deleteMovieFromList(EntityManager con, models.Movie movie, models.FavoriteList list){ 
                list.getMovieCollection().remove(movie);
                con.getTransaction().begin();
                con.persist(list);
                con.getTransaction().commit();
    }
    
    //Δημγουργία λίστας με όλες τις ταινίεσ μίας λίστας ταινιών
    public models.FavoriteList getListByName(EntityManager con, String listName){
    return (models.FavoriteList) con.createNamedQuery("FavoriteList.getListByName").setParameter("listName", listName).getSingleResult();
    }
        
        
    //creates a new FavoriteList instance and saves it to the database
    public void createFavoriteList(EntityManager con, String favName) {
        models.FavoriteList fav = new models.FavoriteList();
        try {
            con.getTransaction().begin();
            fav.setName(favName);
            con.persist(fav);
            con.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            throw (e);
        }
    }

    //edits one favorite list istance
    public void editFavorite(EntityManager con, models.FavoriteList fav, String favName) {

        try {
            models.FavoriteList favFound = con.find(models.FavoriteList.class, fav.getId());

            con.getTransaction().begin();
            favFound.setName(favName);
            con.persist(favFound);
            con.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            throw (e);
        }

    }

    public void deleteFavorite(EntityManager con, models.FavoriteList fav) {

        try {
            models.FavoriteList favFound = con.find(models.FavoriteList.class, fav.getId());
            con.getTransaction().begin();
            con.remove(favFound);
            con.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            throw (e);
      
        }
  
   }
}
