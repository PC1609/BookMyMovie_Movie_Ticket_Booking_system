package Basic_classes;

import com.sun.jdi.request.InvalidRequestStateException;

import java.util.List;

public class Booking {
    String id;
    String user;
    List<Seat> seats;
    Show show;
    Booking_status status;


    public Booking(String id,String user,List<Seat> seats,Show show,Booking_status status){
        this.id=id;
        this.user=user;
        this.seats=seats;
        this.show=show;
        this.status=status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean isConfirmed(){
        return (this.status==Booking_status.CONFIRMED);
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
