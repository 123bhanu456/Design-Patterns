import javax.naming.event.EventDirContext;

public class CanceledPayment implements State{

    VendingMachine vm;
    public CanceledPayment(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insertCoin() {
        System.out.println("u Cancelled Payment pls Collect your coin first");
    }

    @Override
    public void selectItem() {
        System.out.println("u Cancelled Payment pls Collect your coin first");
    }

    @Override
    public void continueProcess() {
        System.out.println("u Cancelled Payment pls Collect your coin first");
    }

    @Override
    public void cancelProcess() {
     System.out.println("U already Cancelled Payment");
    }

    @Override
    public void dispenseItem() {
        System.out.println("U cancelled payment so here is your token");
        vm.setState(vm.getIdleState());
    }
}
