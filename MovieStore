package CollectionFramework.Movies;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    List<Movie> storeMovies = new ArrayList<>();

    public void addMovies(Movie movie) {
        storeMovies.add(movie);
    }

    public List<Movie> displayAllMovies(){
        return storeMovies;
    }

    public Movie search(String movies){
        for(Movie movie : storeMovies){
            if(movie.getName().equals(movies)){
                return movie;
            }
        }
        return null;
    }

    public List<Movie> filter(int year, String language){
        List<Movie> tempMovie = new ArrayList<>();
        for(Movie movie : storeMovies){
            if(year == movie.getYear() || movie.getLanguage().equals(language)){
                tempMovie.add(movie);
            }
        }
        return tempMovie;
    }
}
