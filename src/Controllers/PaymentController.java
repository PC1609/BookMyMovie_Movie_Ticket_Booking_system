package Controllers;

import Basic_classes.Booking;
import Basic_classes.Theatre;
import Services.Payment;
import Services.Ticket_Booking;

public class PaymentController {
    Payment payment;
    Ticket_Booking ticketBooking;

    public PaymentController(Payment payment, Ticket_Booking ticketBooking){
        this.payment=payment;
        this.ticketBooking=ticketBooking;
    }

    public void paymentFailed(String bookingId, String user){
        payment.paymentFailed(ticketBooking.getBooking(bookingId),user);
    }
    public void paymentSuccess(String bookingId){
        ticketBooking.confirmBooking(ticketBooking.getBooking(bookingId));
    }
}
