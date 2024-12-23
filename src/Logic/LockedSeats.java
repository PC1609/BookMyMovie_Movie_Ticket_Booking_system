package Logic;

import Basic_classes.Seat;
import Basic_classes.Show;

import java.util.List;

public interface LockedSeats {
    List<Seat> getLockedSeats(Show show);
    boolean validateSeatLock(Seat seat, String user,Show show);
    void lockSeats(Show show, List<Seat> seats, final Integer timeout, String user);
    void unlockSeats(Show show, List<Seat> seats, String user);
}
