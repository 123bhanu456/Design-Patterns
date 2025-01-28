public class VendingMachine implements State{

    int itemCount=0;
    State idle=new Idle(this);
    State select=new Select(this);
    State payment=new Payment(this);
    State paymentAccepted=new PaymentAccepted(this);
    State canceledPayment=new CanceledPayment(this);
    State state=idle;

     public VendingMachine(int itemCount){
         this.itemCount=itemCount;

     }

     public void setState(State s){
         state=s;
     }

     public State getIdleState() {
         return idle;
     }

     public State getSelectState(){
         return select;
     }

     public State getPaymentState(){
         return payment;

     }

     public State getPaymentAcceptedState(){
         return paymentAccepted;
     }

     public State getCanceledPaymentState(){
         return canceledPayment;
     }


    @Override
    public void insertCoin() {
        state.insertCoin();
    }

    @Override
    public void selectItem() {
        state.selectItem();
    }

    @Override
    public void continueProcess() {
        state.continueProcess();
    }

    @Override
    public void cancelProcess() {
        state.cancelProcess();
    }

    @Override
    public void dispenseItem() {
        state.dispenseItem();
    }


}
