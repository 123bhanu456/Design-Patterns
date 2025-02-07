package Payment;

public class Upi implements Payment{

    @Override
    public void pay() {
        System.out.println("Paying through Upi");
    }
}
