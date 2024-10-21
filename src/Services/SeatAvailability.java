package Services;

import Basic_classes.Booking;
import Basic_classes.Seat;
import Basic_classes.Show;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailability {
    Ticket_Booking ticketBooking;
    LockSeats lockSeats;

    public SeatAvailability(Ticket_Booking ticketBooking, LockSeats lockSeats){
        this.ticketBooking = ticketBooking;
        this.lockSeats =lockSeats;
    }
    public List<Seat> getUnavailableSeats(Show show){
        List<Seat> seats = new ArrayList<>();
        for (Booking bookings : ticketBooking.getAllBookings(show)){
            if (bookings.isConfirmed()) {
                for (Seat seat : bookings.getSeats()) {
                    seats.add(seat);
                }
            }
        }
        for (Seat seat : lockSeats.getLockedSeats(show)){
            if (!seats.contains(seat)){
                seats.add(seat);
            }
        }
        return seats;
    }

    public List<Seat> getAvailableSeats(Show show){
        List<Seat> allSeats = show.getScreen().getSeats();
        allSeats.removeAll(getUnavailableSeats(show));
        return allSeats;
    }
}
