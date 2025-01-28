public class AsynchronousLogger extends LoggerFactory {

    @Override
    public void fn(String msg) {

        new Thread(() -> super.fn2("This message is using async logger   "+msg)).start();
    }

    @Override
    public LoggerFactory createLogger() {
        return new AsynchronousLogger();
    }
}