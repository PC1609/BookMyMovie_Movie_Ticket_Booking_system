package Services;

import Basic_classes.Movie;
import Exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Movies {
    Map<String, Movie> map;

    public Movies(){
        map = new HashMap<>();
    }
    public Movie getMovie(String movieId){
        if (!map.containsKey(movieId)) {
            throw new NotFoundException();
        }
        return map.get(movieId);
    }
    public Movie createNewMovie(String name){
        String id = UUID.randomUUID().toString();
        Movie newMovie = new Movie(name, id);
        map.put(id, newMovie);
        return newMovie;
    }
}
