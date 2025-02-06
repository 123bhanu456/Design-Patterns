package Payment;

public abstract class PaymentFactory {

    public void pay(){
        String mode=paymentMethod();
        System.out.println("Paying using "+mode);

    }
    public abstract String paymentMethod();

}
