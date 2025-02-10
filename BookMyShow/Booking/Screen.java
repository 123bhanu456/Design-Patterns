package Booking;

import java.util.*;

import Notification.Observer;
import Seat.Seat;

public class Screen implements ScreenInf, Publisher {
    private int screen_id;
    private Theater theater;
    private int total_seats;
    private Map<Integer, Map<Integer, Seat>> seatLayout;
    private Movie movie;
    private int rows;
    private int columns;
    private int cur_seat_id;
    private int price;
    private ScreenType screenType;
    List<Observer>obs;


    Screen(int screen_id,int rows, int columns,ScreenType screenType) {
        this.screen_id = screen_id;
        this.rows=rows;
        this.columns=columns;
        total_seats = rows * columns;
        seatLayout = new HashMap<>();
        obs=new ArrayList<Observer>();
        this.movie=null;
        this.screenType=screenType;
        if(screenType==ScreenType.IMAX)price=300;
        else if(screenType==ScreenType._3D)price=250;
        else price=200;
        InitializeSeats(rows, columns);
    }


    void InitializeSeats(int rows, int columns) {
        int seatId = 1;
        for (int row = 1; row <=rows; row++) {
            seatLayout.put(row, new HashMap<>());
            for (int a = 1; a <=columns; a++) {
                Seat seat = new Seat(seatId++, row, a);
                seatLayout.get(row).put(a, seat);
            }
        }
    }



    @Override
    public synchronized boolean blockSeat(int seat_id) {
        int r=seat_id/rows+1;
        int c=seat_id%rows;
        if(seat_id%rows==0){
            c=rows;
            r--;
        }
        Seat seat = seatLayout.get(r).get(c);

        this.cur_seat_id=seat_id;
        return seat.book_seat();


    }


    public void pay() {
        int r=cur_seat_id/rows+1;
        int c=cur_seat_id%rows;
        if(cur_seat_id%rows==0) {
            c = rows;
            r--;
        }
        Seat seat = seatLayout.get(r).get(c);
        seat.pay();

        total_seats--;
    }


    public void undo() {
        int r=cur_seat_id/rows+1;
        int c=cur_seat_id%rows;
        if(cur_seat_id%rows==0) {
            c = rows;
            r--;
        }
        Seat seat = seatLayout.get(r).get(c);
        seat.undo();
    }


    @Override
    public void display_layout() {

        System.out.println("Here is the Display of Seat (X- Booked ,O-Available)");

        for (int row : seatLayout.keySet()) {
            for (int number : seatLayout.get(row).keySet()) {
                Seat seat = seatLayout.get(row).get(number);
                System.out.print((seat.getStatus().equals("booked") ? "[X] "+ seat.getSeat_id(): "[O] "+seat.getSeat_id()) + " ");

            }
            System.out.println();
        }

    }

    @Override
    public void display_layout_afterBooking() {

        System.out.println("Here is the Display of Seat after Booking (X- Booked ,O-Available)");
        int sum=1;
        for (int row : seatLayout.keySet()) {
            for (int number : seatLayout.get(row).keySet()) {
                Seat seat = seatLayout.get(row).get(number);
                System.out.print((seat.getStatus().equals("booked") ? "[X] "+sum++ : "[O] "+sum++) + " ");

            }
            System.out.println();
        }

    }

    @Override
    public void setMovie(Movie movie){
        this.movie=movie;

    }

    @Override
    public String getSeatStatus(int seat_id) {
        int r=seat_id/rows+1;
        int c=seat_id%rows;
        if(seat_id%rows==0){
            c=rows;
            r--;
        }
        Seat seat = seatLayout.get(r).get(c);
        return seat.getStatus();
    }


    public ScreenType getSeatType() {
        return screenType;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getPrice(){
        return price;
    }

    public int getTotal_seats(){
        return total_seats;
    }

    public int getScreen_id(){
        return screen_id;
    }


    @Override
    public void adduser(Observer user) {
        obs.add(user);
    }

    @Override
    public void removeUser(Observer user) {
        obs.remove(user);
    }

    @Override
    public void update() {
        for(Observer user :obs){
            user.notification(this);
        }
    }
}
