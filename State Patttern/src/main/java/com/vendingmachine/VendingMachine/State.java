package com.vendingmachine.VendingMachine;

public interface State {

    void insertCard();
    void selectItem(String name);
    void continueProcess();
    void cancelProcess();
    void dispenseItem();




}
