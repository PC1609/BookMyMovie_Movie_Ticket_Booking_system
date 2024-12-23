package Logic;

import Basic_classes.Movie;
import Basic_classes.Screen;
import Basic_classes.Show;
import Exceptions.NotFoundException;

import java.util.*;

public class Shows {
    Map<String, Show> map;

    public  Shows(){
        this.map= new HashMap<>();
    }

    public Show createShow(Movie movie, Screen screen, Date startTime, Integer duration){
        String id = UUID.randomUUID().toString();
        Show newShow = new Show(id, screen, movie, duration, startTime);
        map.put(id,newShow);
        return newShow;
    }

    public Show getShow(String showId) {
        if (!map.containsKey(showId)) {
            throw new NotFoundException();
        }
        return map.get(showId);
    }

    public List<Show> getShows(Screen screen){
        List<Show> shows = new ArrayList<>();
        for (Show show : map.values()){
            if (show.getScreen().equals(screen)){
                shows.add(show);
            }
        }
        return shows;
    }
}
