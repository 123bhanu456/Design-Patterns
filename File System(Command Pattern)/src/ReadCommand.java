public class ReadCommand implements Command {

    private FileFunction file;
   ReadCommand(FileFunction file){
       this.file=file;
   }
    @Override
    public void execute(String msg) {
        file.read();
    }

    @Override
    public void undo() {
        System.out.println("Read operation cannot be undone");
    }

}
