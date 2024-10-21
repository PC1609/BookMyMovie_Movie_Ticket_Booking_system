package Services;

import Basic_classes.Booking;
import Basic_classes.Seat;
import Basic_classes.SeatLock;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

public class Payment {
    private final Integer retriesAllowed;
    LockSeats lockSeats;
    Map<Booking,Integer> failedBookings;

    public Payment(Integer retriesAllowed, LockSeats lockSeats){
        this.retriesAllowed=retriesAllowed;
        this.lockSeats=lockSeats;
        failedBookings = new HashMap<>();
    }

    public void paymentFailed(Booking booking, String user){
        failedBookings.put(booking, failedBookings.getOrDefault(booking,0)+1);
        if (failedBookings.get(booking)>retriesAllowed){
            lockSeats.unlockSeats(booking.getShow(),booking.getSeats(), user);
        }
    }
}
