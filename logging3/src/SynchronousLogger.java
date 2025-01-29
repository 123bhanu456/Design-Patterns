public class SynchronousLogger extends LoggerFactory {


    public void notify(String msg) {

        super.fn("This message is using sync logger    "+msg);

    }

    @Override
    public LoggerFactory createLogger() {
        return this;
    }
}