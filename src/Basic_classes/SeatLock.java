package Basic_classes;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    Seat seat;
    Show show;
    Date locktime;
    Integer timeout;
    String user;

    public SeatLock(Seat seat, Show show, Date locktime, Integer timeout, String user){
        this.seat=seat;
        this.show=show;
        this.locktime = locktime;
        this.timeout=timeout;
        this.user=user;
    }

    public boolean hasLockExpired(){
        final Instant lockInstant = locktime.toInstant().plusSeconds(timeout);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }

    public String getUser(){
        return this.user;
    }
}
