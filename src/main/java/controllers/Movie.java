package controllers;



import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;


public class Movie {

    //Δημγουργία λίστας με όλα τα αντικείμενα της βάσης δεδομένων
    public List<models.Movie> getAllMovies(EntityManager con){
    return  con.createNamedQuery("Movie.findAll").getResultList();
    }
    public List<models.Movie> findByGenreAndDate(EntityManager con, String genre, Date startDate,Date stopDate){
     return con.createNamedQuery("Movie.findByGenreAndDate")
        .setParameter("startDate", startDate)
        .setParameter("stopDate", stopDate)
        .setParameter("genre", genre)
        .getResultList();
    }
    //Ευρεση ταινίας με κριτήριο το όνομα
    public models.Movie findByName(EntityManager con, String title){
    return  (models.Movie) con.createNamedQuery("Movie.findByTitle").setParameter("title", title).getSingleResult();
    }
    
    //Ειαγωγή ταινίας σε λίστα    
    public void addMovieToAList(EntityManager con, models.Movie movie, models.FavoriteList list){ 
                movie.setFavoriteListId(list);
                con.getTransaction().begin();
                con.persist(movie);
                con.getTransaction().commit();
    }
    
    //Διαγραφή ταινίας από λίστα   
    public void deleteMovieFromAAList(EntityManager con, models.Movie movie){ 
                movie.setFavoriteListId(null);
                con.getTransaction().begin();
                con.persist(movie);
                con.getTransaction().commit();
    }
    
       //Ευρεση των 10 καλύτερων ταινιών   
    public List<models.Movie> getBestMovies(EntityManager con){ 
    return  (List<models.Movie>)  con.createNamedQuery("Movie.getBestMovies").setMaxResults(10).getResultList();
    }
    
    //Επιστρέφει τη ταινία με την υψηλότερη βαθμολογία που υπάρχει σε μία λίστα
    public models.Movie getBestMoviePerList(EntityManager con, String list) {
    return (models.Movie) con.createNamedQuery("Movie.getBestMoviePerList").setParameter("list", list).setFirstResult(0).setMaxResults(1).getSingleResult();
    }   
}