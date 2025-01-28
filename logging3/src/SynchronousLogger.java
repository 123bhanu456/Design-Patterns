public class SynchronousLogger extends LoggerFactory {


    public void fn(String msg) {

        super.fn2("This message is using sync logger    "+msg);

    }

    @Override
    public LoggerFactory createLogger() {
        return new SynchronousLogger();
    }
}