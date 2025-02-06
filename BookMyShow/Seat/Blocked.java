package Seat;

public class Blocked implements State{

    Seat seat;
    Blocked(Seat seat){
        this.seat=seat;
    }
    @Override
    public void book_seat() {
        System.out.println("Go back to previous inorder to book seat");
    }

    @Override
    public void pay(int seat_id) {
        System.out.println("successfully booked SeatNo - "+seat_id);
        seat.setState(seat.getBooked());
    }

    @Override
    public void undo_pay() {
        System.out.println("cancelling the payment");
        seat.setState(seat.getAvailable());
    }

}
