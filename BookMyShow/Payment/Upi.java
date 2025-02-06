package Payment;

public class Upi extends PaymentFactory{
    @Override
    public String paymentMethod() {
        return "UPI";
    }
}
