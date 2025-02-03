package com.vendingmachine.VendingMachine;

public class Idle implements State {

    VendingMachine vm;

    public Idle(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insertCard() {
      System.out.println("Successfully inserted Card");

      vm.setState(vm.getSelectState());
    }



    @Override
    public void selectItem(String name) {
       System.out.println("First u need to insert Coin");
    }

    @Override
    public void continueProcess() {
        System.out.println("First u need to insert Coin");
    }

    @Override
    public void cancelProcess() {
        System.out.println("First u need to insert Coin");
    }

    @Override
    public void dispenseItem() {
         System.out.println("No coin Inserted");
    }



}
