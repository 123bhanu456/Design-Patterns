package Seat;

public class Booked implements State {

    Seat seat;
    Booked(Seat seat){
        this.seat=seat;
    }
    @Override
    public boolean book_seat() {
        System.out.println("This seat is already booked,can not book again");
        return false;
    }

    @Override
    public void pay(int seat_id) {
        System.out.println("This seat is already booked can not pay");
    }

    @Override
    public void undo_pay() {
        System.out.println("This seat is already booked");
    }
}
