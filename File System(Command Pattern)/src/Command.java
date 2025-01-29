public interface Command {

    void execute(String msg);
    void undo();
}
