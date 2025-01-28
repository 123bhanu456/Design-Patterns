public class Main {

    public static void main(String args[]){
        VendingMachine vendingMachine=new VendingMachine(2);

        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.continueProcess();
        vendingMachine.dispenseItem();

        System.out.println();


        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.cancelProcess();
        vendingMachine.dispenseItem();

        System.out.println();

        vendingMachine.selectItem();

        System.out.println();

        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.continueProcess();
        vendingMachine.dispenseItem();

        System.out.println();

        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.continueProcess();






    }

}
