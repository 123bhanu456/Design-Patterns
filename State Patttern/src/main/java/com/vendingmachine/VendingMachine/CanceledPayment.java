package com.vendingmachine.VendingMachine;

public class CanceledPayment implements State {

    VendingMachine vm;
    public CanceledPayment(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insertCard() {
        System.out.println("u Cancelled Payment pls Collect your coin first");
    }

    @Override
    public void selectItem(String name) {
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
        System.out.println("U cancelled payment ");
        vm.itemName=" ";
        vm.setState(vm.getIdleState());
    }
}
