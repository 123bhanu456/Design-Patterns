import java.util.HashSet;
import java.util.Set;

public class LoggerDecorator implements Logger,Publisher
{

    Logger logger;
    LoggerDecorator(Logger logger){
        this.logger=logger;

    }
    @Override
    public void log(String msg) {
        logger.log(msg);
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
        for(Observer o:s)o.print(msg);
    }
}
