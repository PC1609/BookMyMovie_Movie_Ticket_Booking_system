package Services;

import Basic_classes.Screen;
import Basic_classes.Seat;
import Basic_classes.Theatre;
import Exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Theatres {
    Map<String, Theatre> mapTheatre;
    Map<String, Screen> mapScreen;
    Map<String, Seat> mapSeat;

    public Theatres(){
        this.mapTheatre=new HashMap<>();
        this.mapScreen= new HashMap<>();
        this.mapSeat= new HashMap<>();
    }
    public Theatre getTheatre(String id){
        if (!mapTheatre.containsKey(id)){
            throw new NotFoundException();
        }
        return mapTheatre.get(id);
    }
    public Screen getScreen(String id){
        if (!mapScreen.containsKey(id)){
            throw new NotFoundException();
        }
        return mapScreen.get(id);
    }
    public Seat getSeat(String id){
        if (!mapSeat.containsKey(id)){
            throw new NotFoundException();
        }
        return mapSeat.get(id);
    }

    public Theatre createTheatre(String name){
        String id = UUID.randomUUID().toString();
        Theatre newTheatre = new Theatre(id,name, new ArrayList<>());
        mapTheatre.put(id,newTheatre);
        return newTheatre;
    }
    public Screen createScreen (String name, Theatre theatre){
        String id = UUID.randomUUID().toString();
        Screen newScreen = new Screen(name,theatre,id,new ArrayList<>());
        mapScreen.put(id,newScreen);
        return newScreen;
    }
    public Seat createSeatInScreen(Screen screen, String row, String seat_number){
        String id = UUID.randomUUID().toString();
        Seat seat = new Seat(id,row,seat_number);
        screen.getSeats().add(seat);
        mapSeat.put(id,seat);
        return seat;
    }
}
