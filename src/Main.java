import Basic_classes.*;
import Logic.*;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //code here
        Movies movies = new Movies();
        //create 2 movies
        Movie dabang = movies.createNewMovie("Dabang");
        Movie jigra = movies.createNewMovie("Jigra");

        Theatres theatres = new Theatres();
        //create 2 theatres
        Theatre sooraj_theatre = theatres.createTheatre("Sooraj Theatre");
        Theatre mumbai_talkies = theatres.createTheatre("Mumbai Talkies");

        //create 2 screens per theatre
        Screen screen1 = theatres.createScreen("Screen1",sooraj_theatre);
        Screen screen2 = theatres.createScreen("Screen2", sooraj_theatre);
        Screen screen3 = theatres.createScreen("Screen3", mumbai_talkies);
        Screen screen4 = theatres.createScreen("Screen4", mumbai_talkies);

        //create 20 seats per screen
        List<Seat> seats_screen1 = theatres.createSeatInScreen(screen1, 2,4);
        List<Seat> seats_screen2 = theatres.createSeatInScreen(screen2, 2,4);
        List<Seat> seats_screen3 = theatres.createSeatInScreen(screen3, 2,4);
        List<Seat> seats_screen4 = theatres.createSeatInScreen(screen4, 2,4);

        Shows shows = new Shows();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 1); // Year, Month (0-based), Day
        Date specificDate1 = calendar.getTime();
        Show show1 = shows.createShow(dabang,screen1, specificDate1, 120);
        calendar.set(2024, Calendar.DECEMBER, 2); // Year, Month (0-based), Day
        Date specificDate2 = calendar.getTime();
        Show show2 = shows.createShow(jigra,screen2, specificDate2, 150);

        LockSeats lockSeats = new LockSeats(30);
        Ticket_Booking ticketBooking= new Ticket_Booking(lockSeats);

        //1. create a confirmed booking showing seats booked
        List<Seat> seats_to_book = new ArrayList<>();
        int count = 4;
        for (Seat seat : seats_screen1){
            seats_to_book.add(seat);
            count--;
            if (count==0){
                break;
            }
        }
        Booking booking1 = ticketBooking.createBooking(seats_to_book, show1, "Priyanka", 30);

        Payment payment = new Payment(2,lockSeats);
        payment.paymentFailed(booking1, "Priyanka");
        //2. payment.paymentFailed(booking1, "Priyanka");
        //payment.paymentFailed(booking1, "Priyanka");
        ticketBooking.confirmBooking(booking1);

        for (Seat seat : lockSeats.getLockedSeats(show1)){
            String r = seat.getRow_number();
            String sn = seat.getSeat_no();
            System.out.println(seat);
            System.out.println(r+ sn);
        }

        //3. view available seats for a particular show
        SeatAvailability seatAvailability = new SeatAvailability(ticketBooking, lockSeats);
        System.out.println("AVAILABLE SEATS OF SHOW1 ARE");
        for (Seat seat : seatAvailability.getAvailableSeats(show1)){
            String r = seat.getRow_number();
            String sn = seat.getSeat_no();
            System.out.println(seat);
            System.out.println(r + sn);
        }

        //4. exception when try to book confirmed seats by another user
        //Booking booking2 = ticketBooking.createBooking(seats_to_book, show1, "Tina", 30);

        //5. see seats locked for how much time?
        List<Seat> seats_to_book_show2 = new ArrayList<>();
        int count2 = 3;
        for (Seat seat : seats_screen2){
            seats_to_book_show2.add(seat);
            count2--;
            if (count2==0){break;}
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fxn number you want to execute");
        int ans = scanner.nextInt();

        if(ans==3){
            Booking booking3 = ticketBooking.createBooking(seats_to_book_show2,show2, "Sumit", 5);
            //see if seats were locked
            for (Seat seat : seats_to_book_show2){
                System.out.println(lockSeats.isSeatLocked(show2, seat));
            }
        }
        //after locking too seats become unavailable, so not visible in available seats
        System.out.println("AVAILABLE SEATS OF SHOW2 ARE");
        for (Seat seat : seatAvailability.getAvailableSeats(show2)){
            String r = seat.getRow_number();
            String sn = seat.getSeat_no();
            System.out.println(seat);
            System.out.println(r + sn);
        }

        System.out.println("Enter if want to execute next fxn");
        ans = scanner.nextInt();
        if (ans==4){
            //have seats been unlocked after timeout of 20 sec, can be booked now
            for (Seat seat : seats_to_book_show2){
                System.out.println(lockSeats.isSeatLocked(show2, seat));
            }
            Booking booking4 = ticketBooking.createBooking(seats_to_book_show2,show2,"Mukesh", 20);
            ticketBooking.confirmBooking(booking4);
            System.out.println(booking4.getUser());
        }

    }
}