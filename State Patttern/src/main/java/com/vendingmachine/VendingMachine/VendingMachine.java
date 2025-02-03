package com.vendingmachine.VendingMachine;

import java.util.Map;

public class VendingMachine implements State {

    Map<String, Item> items;
    MongoDB dbHelper;
    double balance;



    State idle=new Idle(this);
    State select=new Select(this);
    State payment=new Payment(this);
    State paymentAccepted=new PaymentAccepted(this);
    State canceledPayment=new CanceledPayment(this);
    State state=idle;
    String itemName;

     public VendingMachine(){
         dbHelper = new MongoDB();
         items = dbHelper.loadItems();
         balance = dbHelper.getMachineBalance();

     }

     public void setState(State s){
         state=s;
     }

     public State getIdleState() {
         return idle;
     }

     public State getSelectState(){
         return select;
     }

     public State getPaymentState(){
         return payment;

     }

     public State getPaymentAcceptedState(){
         return paymentAccepted;
     }

     public State getCanceledPaymentState(){
         return canceledPayment;
     }


    @Override
    public void insertCard() {
         state.insertCard();
    }

    @Override
    public void selectItem(String name) {
        state.selectItem(name);
    }

    @Override
    public void continueProcess() {
        state.continueProcess();
    }

    @Override
    public void cancelProcess() {
        state.cancelProcess();
    }

    @Override
    public void dispenseItem() {
        state.dispenseItem();
    }

    public void DisplayBalance(){
         System.out.println("Total amount Collected by Vending Machine = "+dbHelper.getMachineBalance());
    }


}
