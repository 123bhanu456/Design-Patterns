package Payment;

public class PaymentFactory {

    public Payment getPayemntObj(PaymentMethod paymentMethod){
         if(paymentMethod==PaymentMethod.UPI)return new Upi();
         else if(paymentMethod==PaymentMethod.CREDIT)return new Credit();
         else if(paymentMethod==PaymentMethod.DEBIT)return new Debit();

         return null;
    }





}
