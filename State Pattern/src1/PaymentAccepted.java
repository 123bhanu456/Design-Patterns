public class PaymentAccepted implements State{

    VendingMachine vm;

    public PaymentAccepted (VendingMachine vm) {
        this.vm = vm;
    }
    @Override
    public void insertCoin() {
        System.out.println("Take out the Desired item first");
    }

    @Override
    public void selectItem() {
        System.out.println("Take out the Desired item first");
    }

    @Override
    public void continueProcess() {
            System.out.println("Payment already done");
    }

    @Override
    public void cancelProcess() {
        System.out.println("Payment already done");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item Dispatched");
        vm.itemCount--;
        vm.setState(vm.getIdleState());
    }
}
