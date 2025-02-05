import java.util.*;

import Seat.Seat;

public class Screen {
    int screen_id;
    Theater theater;
    int total_seats;
    Map<Integer, Map<Integer, Seat>> seatLayout;
    Movie movie;


    int bookingRow = -1;
    int bookingColumn = -1;

    Screen(int screen_id,int rows, int seats_in_rows) {
        this.screen_id = screen_id;
        total_seats = rows * seats_in_rows;
        seatLayout = new HashMap<>();
        this.movie=null;

        InitializeSeats(rows, seats_in_rows);
    }

    void InitializeSeats(int rows, int seats_in_rows) {
        int seatId = 1;
        for (int row = 1; row <= rows; row++) {
            seatLayout.put(row, new HashMap<>());
            for (int a = 1; a <=seats_in_rows; a++) {
                Seat seat = new Seat(seatId++, row, a);
                seatLayout.get(row).put(a, seat);
            }
        }
    }


    public Seat getSeat(int row, int c) {
        return seatLayout.get(row).get(c);
    }


    public void blockSeat(int row, int c) {
        if(movie==null) {
            System.out.println("No movie Currently Running in this screen");
            return;
        }
        Seat seat = seatLayout.get(row).get(c);
        if(seat.getStatus().equals("booked")){
            System.out.println("Already Booked the seat with id "+seat.getSeat_id());
            return;
        }
        seat.book_seat();
        bookingRow = row;
        bookingColumn = c;

    }

    public void pay() {
        if (bookingRow == -1) {
            System.out.println("First Block a Seat");
            return;
        }
        Seat seat = seatLayout.get(bookingRow).get(bookingColumn);
        seat.pay();
        bookingRow = -1;
        bookingColumn = -1;

        total_seats--;
    }

    public void undo() {
        Seat seat = seatLayout.get(bookingRow).get(bookingColumn);
        seat.undo();
        bookingRow = -1;
        bookingColumn = -1;
    }

    public void display_layout() {

        System.out.println("Here is the Display of Seat (X- Booked ,O-Available)");
        for (int row : seatLayout.keySet()) {
            for (int number : seatLayout.get(row).keySet()) {
                Seat seat = seatLayout.get(row).get(number);
                System.out.print((seat.getStatus().equals("booked") ? "[X]" : "[O]") + " ");
            }
            System.out.println();
        }

    }
    public void display_layout_afterBooking() {

        System.out.println("Here is the Display of Seat after Booking (X- Booked ,O-Available)");
        for (int row : seatLayout.keySet()) {
            for (int number : seatLayout.get(row).keySet()) {
                Seat seat = seatLayout.get(row).get(number);
                System.out.print((seat.getStatus().equals("booked") ? "[X]" : "[O]") + " ");
            }
            System.out.println();
        }

    }

    public void setMovie(Movie movie){
        this.movie=movie;
    }


}
