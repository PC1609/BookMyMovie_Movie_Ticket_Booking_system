package Services;

import Basic_classes.Booking;
import Basic_classes.Booking_status;
import Basic_classes.Seat;
import Basic_classes.Show;
import Exceptions.NotFoundException;
import Exceptions.SeatBookedException;

import java.util.*;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class Ticket_Booking {
    Map<String, Booking> map;
    LockSeats lockSeats;

    public Ticket_Booking(LockSeats lockSeats){
        this.lockSeats = lockSeats;
        map= new HashMap<>();
    }

    public Booking getBooking(String id){
        if(!map.containsKey(id)){
            throw new NotFoundException();
        }
        return map.get(id);
    }

    public List<Booking> getAllBookings(Show showw){
        List<Booking> allBookings = new ArrayList<>();
        for (Booking booking : map.values()){
            if (booking.getShow().equals(showw)){
                allBookings.add(booking);
            }
        }
        return allBookings;
    }
    public Booking createBooking(List<Seat> seats, Show show, String user, Integer timeout){
            for (Booking booking : getAllBookings(show)){ //can book seats which are not confirmed
                if (booking.isConfirmed()){
                    for (Seat seat : seats){
                        if (booking.getSeats().contains(seat)){
                            throw new SeatBookedException("Seat is booked");
                        }
                    }
                }
            }
        String id = UUID.randomUUID().toString();
        Booking newBooking = new Booking(id,user,seats, show, Booking_status.CREATED);
        map.put(id,newBooking);
        lockSeats.lockSeats(show,seats, timeout,user);
        return newBooking;
    }

    public void confirmBooking(Booking booking){
        for (Seat seat : booking.getSeats()){
            if (!lockSeats.getLockedSeats(booking.getShow()).contains(seat)){
                throw new NotFoundException();
            }
        }
        if (!map.containsValue(booking)){
            throw new NotFoundException();
        }
        booking.confirmBooking();
    }
}
