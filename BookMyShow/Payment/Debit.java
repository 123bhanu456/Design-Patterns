package Payment;

public class Debit implements Payment{

    @Override
    public void pay() {
        System.out.println("Paying through Debit");
    }
}
