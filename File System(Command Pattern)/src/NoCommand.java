public class NoCommand implements Command{
    @Override
    public void execute(String msg) {
        System.out.println("No command assigned.");
    }

    @Override
    public void undo() {
        System.out.println("No command to undo");
    }
}
