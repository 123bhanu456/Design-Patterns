public class WriteCommand implements Command{

    FileFunction file;

    WriteCommand(FileFunction file){
        this.file=file;

    }

    @Override
    public void execute(String msg) {
        file.write(msg);
    }

    @Override
    public void undo() {
     file.undoWrite();
    }
}
