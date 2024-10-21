package Controllers;

import Basic_classes.Movie;
import Services.Movies;

public class MovieController {
    Movies movies;

    public MovieController(Movies movies){
        this.movies=movies;
    }

    public String createMovie(String name){
        return movies.createNewMovie(name).getId();
    }
}
