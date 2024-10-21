package Controllers;

import Basic_classes.Seat;
import Basic_classes.Show;
import Basic_classes.Theatre;
import Services.Shows;
import Services.Theatres;
import Services.Ticket_Booking;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    Shows shows;
    Theatres theatres;
    Ticket_Booking ticketBooking;

    public BookingController(Shows shows, Theatres theatres, Ticket_Booking ticketBooking){
        this.shows = shows;
        this.theatres=theatres;
        this.ticketBooking=ticketBooking;
    }

    public String createBooking(String user, String showId, List<String> seatsId, Integer timeout){
        Show show = shows.getShow(showId);
        List<Seat> seats = seatsId.stream().map(theatres::getSeat).collect(Collectors.toList());
        return ticketBooking.createBooking(seats,show,user,timeout).getId();
    }
}
