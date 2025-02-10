package Seat;

public class Seat {

   int seat_id;
   int row;
   int number;
   State state;

   State available=new Available(this);
   State blocked=new Blocked(this);
   State booked= new Booked(this);


   public Seat(int seat_id, int row, int number){
      state=available;
      this.seat_id=seat_id;
      this.row=row;
      this.number=number;
   }

    public boolean book_seat(){
      return state.book_seat();
   }

    public void pay(){
      state.pay(seat_id);
   }

   public void undo(){
      state.undo_pay();
   }

   public void setState(State state) {
      this.state = state;
   }

   public State getAvailable() {
      return available;
   }

   public State getBlocked(){
      return blocked;
   }

   public State getBooked(){
      return booked;
   }

   public int getSeat_id(){
      return seat_id;
   }

   public String getStatus(){
      String s;
      if(state==available)s="available";
      else if(state==blocked)s="blocked";
      else s="booked";

      return s;
   }
}
