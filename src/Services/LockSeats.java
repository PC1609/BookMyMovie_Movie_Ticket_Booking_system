package Services;

import Basic_classes.Seat;
import Basic_classes.SeatLock;
import Basic_classes.Show;
import com.sun.jdi.request.InvalidRequestStateException;

import java.util.*;

public class LockSeats implements LockedSeats{
    Map<Show, Map<Seat, SeatLock>> map;
    private final Integer timeout;

    public LockSeats(Integer timeout){
        this.timeout=timeout;
        map= new HashMap<>();
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        if (!map.containsKey(show)){
            return;
        }
        for (Seat seat: seats){
            map.get(show).remove(seat);
        }
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, final Integer timeout, String user) {
        if (!map.containsKey(show)){
            map.put(show, new HashMap<>());
        }
        for (Seat seat : seats){
            if (isSeatLocked(show,seat)){
                continue;
            }
            map.get(show).put(seat, new SeatLock(seat, show,new Date(),timeout ,user));
        }
    }

    public boolean isSeatLocked(Show show, Seat seat){
        return map.containsKey(show) && map.get(show).containsKey(seat) && !map.get(show).get(seat).hasLockExpired();
    }

    @Override
    public boolean validateSeatLock(Seat seat, String lockedBy, Show show) {
        return isSeatLocked(show,seat) && map.get(show).get(seat).getUser().equals(lockedBy);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        List<Seat> lockedSeats = new ArrayList<>();
        Map<Seat,SeatLock> newMap = map.get(show);
        for (Map.Entry<Seat,SeatLock> entry : newMap.entrySet()){
            if (isSeatLocked(show,entry.getKey())){
                lockedSeats.add(entry.getKey());
            }
        }
        return lockedSeats;
    }
}
