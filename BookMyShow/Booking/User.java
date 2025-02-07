package Booking;
import Payment.Payment;

import java.util.List;

public class User implements UserInf {
     private int user_id;
     private String name;
     private String email;
     private String phoneNumber;




    public User(int user_id, String phoneNumber, String name, String email){
        this.user_id=user_id;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.name=name;
    }

    @Override
    public void book_show(Show show, int seat_id, Payment payment){
        if(show.getScreen()==null){
            System.out.println(show.getMovie().getName()+" is not present this theater");
            return;
        }

        if(show.getScreen().getSeatStatus(seat_id).equals("booked")){
            System.out.println("The Seat id - "+seat_id+" is already booked choose another");
            return;
        }
        System.out.println("Total amount to pay = "+show.getPrice());
        payment.pay();
        show.bookShow(seat_id);
        show.display_seat_after_booking();
    }

    @Override
    public void book_show(Show show, List<Integer>arr,Payment payment){
        if(show.getScreen()==null){
            System.out.println(show.getMovie().getName()+" is not present this theater");
            return;
        }



        boolean t=true;
        for(Integer integer:arr){
            if(show.getScreen().getSeatStatus(integer).equals("booked")){
                System.out.println("The Seat id - "+integer+" is already booked choose another");
                t=false;
            }
        }
        if(!t)return;

        System.out.println("Total amount to pay = "+show.getPrice()*arr.size());
        payment.pay();
        for (Integer integer : arr) {

            show.bookShow(integer);
        }


        show.display_seat_after_booking();
    }

    public void show_available_seats(Show show){
        if(show.getScreen()==null){
            System.out.println("No movie present in this theater");
            return;
        }
        show.showAvailable_seats();
    }

    public String getName() {
        return name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
