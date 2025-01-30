public class AsynchronousLoggerFactory extends LoggerFactory {

    @Override
    public void notify(String msg) {

        new Thread(() -> super.fn("This message is using async logger   "+msg)).start();
    }

    @Override
    public LoggerFactory createLogger() {
        return this;
    }
}