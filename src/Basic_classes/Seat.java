package Basic_classes;

import com.sun.jdi.request.InvalidRequestStateException;

public class Seat {
    private final String id;
    private final String row_number;
    private final String seat_no;


    public Seat(String id,  String row_number, String seat_no){
        this.id=id;
        this.row_number=row_number;
        this.seat_no=seat_no;
    }
    public String getId(){
        return id;
    }

    public String getRow_number() {
        return row_number;
    }

    public String getSeat_no() {
        return seat_no;
    }
}
