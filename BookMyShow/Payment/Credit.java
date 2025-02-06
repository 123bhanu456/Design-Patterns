package Payment;

public class Credit extends PaymentFactory{
    @Override
    public String paymentMethod() {
        return "CreditCard";
    }
}
