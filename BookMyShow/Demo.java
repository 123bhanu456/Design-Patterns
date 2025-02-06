import Booking.*;
import DataBase.MovieStorage;
import DataBase.ShowStorage;
import Payment.Credit;
import Payment.Debit;
import Payment.PaymentFactory;
import Payment.Upi;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
       Theater shiva =new Theater(1,3,"Shiva","Guntur");
       Theater x=new Theater(2,3,"x","hyd");
       Theater y=new Theater(3,3,"y","pune");

       Movie interstellar=new Movie(1,"interstellar",Genre.SCI_FI,3,4.5);
       Movie jersey=new Movie(2,"jersey",Genre.DRAMA,3,4.5);

       shiva.initMovieScreen(1,5,5,ScreenType._3D);
       shiva.initMovieScreen(2,5,5, ScreenType._2D);

       x.initMovieScreen(1,5,5,ScreenType._3D);
       x.initMovieScreen(2,5,5, ScreenType._2D);

       y.initMovieScreen(1,5,5,ScreenType._3D);
       y.initMovieScreen(2,5,5, ScreenType._2D);

       shiva.setCurrent_movies(interstellar);
       shiva.setCurrent_movies(jersey);

       x.setCurrent_movies(jersey);

       y.setCurrent_movies(interstellar);



       Show show1=new Show(1,jersey,shiva,"3:30");
       Show show2=new Show(2,interstellar,shiva,"6:00");
       Show show3=new Show(3,jersey,x,"6:00");
       Show show4=new Show(3,interstellar,y,"3:00");


       ShowStorage showStorage=new ShowStorage();
       MovieStorage movieStorage =new MovieStorage();

       movieStorage.addMovie(interstellar);
       movieStorage.addMovie(jersey);

       showStorage.addShow(show1);
       showStorage.addShow(show2);
       showStorage.addShow(show3);
       showStorage.addShow(show4);

       User bhanu=new User(1,"9494258876","Bhanu","Abc@yo.com");
       PaymentFactory upi=new Upi();
       PaymentFactory credit=new Credit();
       PaymentFactory debit=new Debit();

       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter movie name to search: ");
       String movieName = scanner.nextLine();
       Movie User_Movie;

       if (movieStorage.containsMovie(movieName)) {
          User_Movie = movieStorage.getMovie(movieName);
          System.out.println("Movie found: " + User_Movie.getName());
       } else {
          System.out.println("Movie not found.");
          return;
       }

       List<Show> availableShows = showStorage.searchShowsByMovie(User_Movie);
       if (availableShows.isEmpty()) {
          System.out.println("No shows available for " + movieName);
          return ;
       }

       System.out.println("Available shows:");
       for (int i = 0; i < availableShows.size(); i++) {
          System.out.print((i + 1) + ". ");
          availableShows.get(i).displayShowDetails();
       }

       System.out.print("Select a show to book (Enter number): ");
       int showIndex = scanner.nextInt() - 1;
       if (showIndex < 0 || showIndex >= availableShows.size()) {
          System.out.println("Invalid selection.");
          return;
       }

       Show selectedShow = availableShows.get(showIndex);
       selectedShow.showAvailable_seats();


       System.out.println("Enter Seat_id to book");
       int seat=scanner.nextInt();

       System.out.println("Choose Payment Option");
       System.out.println("1 -UPI  :  2-CreditCard   :  3-DebitCard");

       int pay_opt=scanner.nextInt();
       PaymentFactory f;

       if(pay_opt==1)f=upi;
       else if(pay_opt==2)f=credit;
       else f=debit;

       bhanu.book_show(selectedShow,seat,f);










//
//       List<Integer>arr=new ArrayList<>(); arr.add(7);arr.add(9);
//       List<Integer>arr2=new ArrayList<>(); arr2.add(8);arr2.add(9);arr2.add(10);


//       bhanu.show_available_seats(show1);
//       bhanu.book_show(show1,arr,upi);
//
//       System.out.println();
//       bhanu.book_show(show1,arr2,upi);
//
//       System.out.println();
//       bhanu.book_show(show1,5,upi);




    }
}
