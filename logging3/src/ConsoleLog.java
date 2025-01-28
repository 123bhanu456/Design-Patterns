public class ConsoleLog implements Observer {

    @Override
    public void print(String msg) {
        System.out.println("This being printed in console -" + msg);
    }
}
