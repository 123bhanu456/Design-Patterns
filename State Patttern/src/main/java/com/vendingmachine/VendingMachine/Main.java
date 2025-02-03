package com.vendingmachine.VendingMachine;


public class Main {

    public static void main(String args[]){

        VendingMachine vendingMachine=new VendingMachine();

        vendingMachine.insertCard();
        vendingMachine.selectItem("Pepsi");
        vendingMachine.continueProcess();
        vendingMachine.dispenseItem();

        vendingMachine.DisplayBalance();

        System.out.println();








    }

}
