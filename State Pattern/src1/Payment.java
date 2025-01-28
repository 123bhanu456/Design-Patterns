public class Payment implements State{
    VendingMachine vm;
    public Payment(VendingMachine vm){
        this.vm=vm;
    }

    @Override
    public void insertCoin() {
        System.out.println("First complete the ongoing payment");
    }

    @Override
    public void selectItem() {
        System.out.println("Already selected");
    }

    @Override
    public void continueProcess() {
        System.out.println("Payment Done");
      vm.setState(vm.getPaymentAcceptedState());

    }

    @Override
    public void cancelProcess() {
        System.out.println("Canceled Payment");
        vm.setState(vm.getCanceledPaymentState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Pls take ur Desired item");
    }

}
