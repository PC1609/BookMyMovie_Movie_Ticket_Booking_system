package Basic_classes;

import com.sun.jdi.request.InvalidRequestStateException;

import java.util.List;

public class Booking {
    String id;
    String user;
    List<Seat> seats;
    Show show;
    //Screen screen;
    //Theatre theatre;
    Booking_status status;


    public Booking(String id,String user,List<Seat> seats,Show show,Booking_status status ){
        this.id=id;
        this.user=user;
        this.seats=seats;
        this.show=show;
        //this.screen=screen;
        //this.theatre=theatre;
        this.status=status;
    }


    public boolean isConfirmed(){
        return (this.status==Booking_status.CONFIRMED);
    }

    public String getId(){
        return id;
    }

    public Show getShow(){
        return this.show;
    }

    public List<Seat> getSeats() {
        return this.seats;
    }

    public void confirmBooking(){
        //initially all bookings are created
        if (this.status != Booking_status.CREATED){
            throw new InvalidRequestStateException();
        }
        this.status = Booking_status.CONFIRMED;
    }

    public void expireBooking(){
        if (this.status != Booking_status.CREATED){
            throw new InvalidRequestStateException();
        }
        this.status = Booking_status.EXPIRED;
    }

}
