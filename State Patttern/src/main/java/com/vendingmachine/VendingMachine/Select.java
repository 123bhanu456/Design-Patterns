package com.vendingmachine.VendingMachine;

public class Select implements State {
    VendingMachine vm;
    public Select(VendingMachine vm){
        this.vm=vm;
    }



    @Override
    public void insertCard() {
        System.out.println("Already inserted");
    }

    @Override
    public void selectItem(String name) {
        Item item=vm.items.get(name);

        if(item.getCount()==0){
            System.out.println(name+" is not available");
            vm.setState(vm.getIdleState());
        }
        else {
            System.out.println(name+" Selected");
            vm.itemName=name;
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
