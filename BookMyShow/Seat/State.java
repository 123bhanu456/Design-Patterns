package Seat;

public interface State {
    public boolean book_seat();
    public void pay(int seat_id);
    public void undo_pay();
}
