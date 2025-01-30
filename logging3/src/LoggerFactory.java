public abstract class LoggerFactory implements Logger,Publisher {


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


    public abstract LoggerFactory createLogger();
    public abstract void notify(String msg);


}
