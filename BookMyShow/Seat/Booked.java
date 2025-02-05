package Seat;

public class Booked implements State {

    Seat seat;
    Booked(Seat seat){
        this.seat=seat;
    }
    @Override
    public void book_seat() {
        System.out.println("This seat is already booked");
    }

    @Override
    public void pay() {
        System.out.println("This seat is already booked");
    }

    @Override
    public void undo_pay() {
        System.out.println("This seat is already booked");
    }
}
