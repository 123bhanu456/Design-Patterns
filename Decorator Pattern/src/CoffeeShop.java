public class CoffeeShop {

    public static void main(String args[]){
        Coffee mycof=new SimpleCoffee();

        System.out.println(mycof.getDescription()+" $"+mycof.getCost());

        //add extra milk;
        mycof= new MilkDecorator(mycof);

        System.out.println(mycof.getDescription()+" $"+mycof.getCost());

        mycof=new SugarDecorator(mycof);

        System.out.println(mycof.getDescription()+" $"+mycof.getCost());
    }
}



