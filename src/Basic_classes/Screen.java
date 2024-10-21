package Basic_classes;

import java.util.List;
import java.util.Random;

public class Screen {
    private final String id;
    List<Seat> seats;
    private final String name;
    private final Theatre theatre;

    public Screen(String name,Theatre theatre, String id, List<Seat> seats){
        this.id=id;
        this.name = name;
        this.seats = seats;
        this.theatre= theatre;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }
    public List<Seat> getSeats(){
        return seats;
    }
    public String getId(){
        return id;
    }
}
