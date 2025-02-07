package Payment;

public class Credit implements Payment{


    @Override
    public void pay() {
        System.out.println("Paying through Credit");
    }
}
