public class ServerLog implements Observer {

    @Override
    public void print(String msg) {
        System.out.println("This being printed in server -" + msg);
    }
}
