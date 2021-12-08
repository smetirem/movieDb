
package models.jsonResponse;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import models.Genre;


public class GenresList {
    @SerializedName("genres")
    private ArrayList<Genre> genres;

    public ArrayList<Genre> getGenres() {
        return genres;
    }
}
