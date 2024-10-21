package Controllers;

import Basic_classes.Screen;
import Basic_classes.Seat;
import Basic_classes.Theatre;
import Services.Theatres;

import java.util.List;

public class TheatreController {
    Theatres theatres;

    public TheatreController(Theatres theatres){
        this.theatres =theatres;
    }

    public String createTheatre(String name){
        Theatre theatre = theatres.createTheatre(name);
        return theatre.getId();
    }

    public String createScreenInTheatre(String name, String theatreId){
        Theatre theatre = theatres.getTheatre(theatreId);
        return theatres.createScreen(name, theatre).getId();
    }
    public String createSeatInScreen(String screenId, String row, String seat_number){
        Screen screen = theatres.getScreen(screenId);
        return theatres.createSeatInScreen(screen,row,seat_number).getId();
    }
}
