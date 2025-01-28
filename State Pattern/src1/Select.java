import java.util.Optional;

public class Select implements State{
    VendingMachine vm;
    public Select(VendingMachine vm){
        this.vm=vm;
    }

    public void insertCoin() {
        System.out.println("Already inserted");
    }

    @Override
    public void selectItem() {
        if(vm.itemCount==0){
            System.out.println("No items Present");
            vm.setState(vm.getIdleState());
        }
        else{
            System.out.println("Selecting item");
            vm.setState(vm.getPaymentState());
        }
    }

    @Override
    public void continueProcess() {
        System.out.println("Please select item first");
    }

    @Override
    public void cancelProcess() {
        System.out.println("Please select item first");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select item first");
    }


}
