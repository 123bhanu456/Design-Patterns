public class LoggerFactory implements Logger,Publisher {


    @Override
    public void log(String msg) {
        LoggerFactory l=createLogger();
        l.notify(msg);
    }

    public void fn(String msg){
        notifyObserver(msg);
    }

    @Override
    public void addObserver(Observer obs) {
        s.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        s.remove(obs);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer o : s) o.print(msg);
    }

    public SynchronousLogger getSynchronousLogger(){
        return new SynchronousLogger();
    }

    public AsynchronousLogger getAsynchronousLogger(){
        return new AsynchronousLogger();
    }







    public LoggerFactory createLogger(){
        return this;
    }
    public void notify(String msg){

    }
}
