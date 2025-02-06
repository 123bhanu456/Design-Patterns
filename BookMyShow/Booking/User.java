package Booking;

import Payment.PaymentFactory;

import java.util.List;

public class User implements UserInf {
     int user_id;
     String name;
     String email;
    String phoneNumber;


    public User(int user_id, String phoneNumber, String name, String email){
        this.user_id=user_id;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.name=name;
    }

    @Override
    public void book_show(Show show, int seat_id, PaymentFactory payment){
        if(show.screen==null){
            System.out.println(show.movie.title+" is not present this theater");
            return;
        }

        if(show.screen.getSeatStatus(seat_id).equals("booked")){
            System.out.println("The Seat id - "+seat_id+" is already booked choose another");
            return;
        }
        System.out.println("Total amount to pay = "+show.price);
        payment.pay();
        show.bookShow(seat_id);
        show.display_seat_after_booking();
    }

    @Override
    public void book_show(Show show, List<Integer>arr,PaymentFactory payment){
        if(show.screen==null){
            System.out.println(show.movie.title+" is not present this theater");
            return;
        }



        boolean t=true;
        for(Integer integer:arr){
            if(show.screen.getSeatStatus(integer).equals("booked")){
                System.out.println("The Seat id - "+integer+" is already booked choose another");
                t=false;
            }
        }
        if(!t)return;

        System.out.println("Total amount to pay = "+show.price*arr.size());
        payment.pay();
        for (Integer integer : arr) {

            show.bookShow(integer);
        }


        show.display_seat_after_booking();
    }

    public void show_available_seats(Show show){
        if(show.screen==null){
            System.out.println("No movie present in this theater");
            return;
        }
        show.showAvailable_seats();
    }












}
