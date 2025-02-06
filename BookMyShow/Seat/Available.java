package Seat;

public class Available implements State{

    Seat seat;
    Available(Seat seat){
        this.seat=seat;
    }
    @Override
    public void book_seat() {
        System.out.println("Booking seat_id - " + seat.getSeat_id());
        seat.setState(seat.getBlocked());
    }

    @Override
    public void pay(int seat_id) {
        System.out.println("please book seats first");
    }

    @Override
    public void undo_pay() {
        System.out.println("please book seats first");
    }
}
