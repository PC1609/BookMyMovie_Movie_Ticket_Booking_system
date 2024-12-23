package Logic;

import Basic_classes.Screen;
import Basic_classes.Seat;
import Basic_classes.Theatre;
import Exceptions.NotFoundException;

import java.util.*;

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
    public List<Seat> createSeatInScreen(Screen screen, int rows, int seats_per_row){
        List<Seat> seats = new ArrayList<>();
        for (int i=0;i<rows; i++){
            for (int j=0;j<seats_per_row; j++){
                String id = UUID.randomUUID().toString();
                Seat seat = new Seat(id,i+" ",j+" ");
                seats.add(seat);
                screen.getSeats().add(seat);
                mapSeat.put(id,seat);
            }
        }
        return seats;
    }
}
