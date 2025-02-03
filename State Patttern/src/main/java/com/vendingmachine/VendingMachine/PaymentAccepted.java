package com.vendingmachine.VendingMachine;

public class PaymentAccepted implements State {

    VendingMachine vm;

    public PaymentAccepted (VendingMachine vm) {
        this.vm = vm;
    }
    @Override
    public void insertCard() {
        System.out.println("Take out the Desired item first");
    }

    @Override
    public void selectItem(String name) {
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
        System.out.println(vm.itemName+" Dispatched");
        vm.items.get(vm.itemName).setCount(vm.items.get(vm.itemName).getCount()-1);
        vm.dbHelper.updateItemCount(vm.itemName,vm.items.get(vm.itemName).getCount());
        System.out.println(vm.itemName +" remaining count = "+vm.items.get(vm.itemName).getCount());
        vm.itemName=" ";
        vm.setState(vm.getIdleState());
    }
}
