package Controllers;

import Basic_classes.*;
import Services.Movies;
import Services.SeatAvailability;
import Services.Shows;
import Services.Theatres;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {
    Movies movies;
    Theatres theatres;
    Shows shows;
    SeatAvailability seatAvailability;

    public ShowController(Movies movies,Theatres theatres, Shows shows, SeatAvailability seatAvailability){
        this.movies=movies;
        this.theatres=theatres;
        this.shows=shows;
        this.seatAvailability=seatAvailability;
    }

    public String createShow(String movieId, String screenId, Date startTime, Integer duration){
        Movie movie = movies.getMovie(movieId);
        Screen screen = theatres.getScreen(screenId);
        return shows.createShow(movie,screen,startTime,duration).getId();
    }
    public List<String> getAvailableSeats(String showId){
        List<Seat> availableSeats = seatAvailability.getAvailableSeats(shows.getShow(showId));
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
