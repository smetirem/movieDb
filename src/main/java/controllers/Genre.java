
package controllers;

import java.util.List;
import javax.persistence.EntityManager;


public class Genre {

    
    public static List getAllGenresFromDerbyDb(EntityManager con){
        return con.createNamedQuery("Genre.findAll").getResultList();
    }
    
}
