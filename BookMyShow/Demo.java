public class Demo {
    public static void main(String[] args) {
       Theater theater =new Theater(3,"Shiva","Guntur",1);
       Movie interstellar=new Movie(1,"Interstellar",Genre.SCI_FI,3,4.5);
       theater.setCurrent_movies(interstellar);

       Show show=new Show(1,interstellar,theater,"3:30");

       show.getAvailable_seats();
       show.bookShow(4,4);

       show.getAvailable_seats();
       show.bookShow(5,4);

        show.getAvailable_seats();
        show.bookShow(3,3);



    }
}
