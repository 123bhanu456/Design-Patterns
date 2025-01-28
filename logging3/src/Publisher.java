import java.util.HashSet;
import java.util.Set;

public interface Publisher {
    Set<Observer> s = new HashSet<>();

    void addObserver(Observer obs);

    void removeObserver(Observer obs);

    void notifyObserver(String msg);
}
