package Payment;

public class Debit extends PaymentFactory{
    @Override
    public String paymentMethod() {
        return "DebitCard";
    }
}
