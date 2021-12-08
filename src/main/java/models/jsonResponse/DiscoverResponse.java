
package models.jsonResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Movie;


      public class DiscoverResponse {
 
            private int page;
            private int total_pages;
            private int total_results;
            private ArrayList<Movie> results;
            private Map<Integer, Movie> mapResults;

    public DiscoverResponse() {
    }

        public ArrayList getResults() {
            return results;
        }
        
        public Map getMapped(){
            this.mapResults = new HashMap<Integer, Movie>();
            this.results.forEach((movie) -> {
                this.mapResults.put(movie.getId(), movie);
            });
            return this.mapResults;
        }

    @Override
    public String toString() {
        return "DiscoverResponse{" + "page=" + page + ", total_pages=" + total_pages + ", total_results=" + total_results + ", results=" + results + ", mapResults=" + mapResults + '}';
    }
        
        
}
