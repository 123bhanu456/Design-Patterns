public class ReadNWriteCommand implements Command{

    FileFunction file;

    ReadNWriteCommand(FileFunction file){
        this.file=file;
    }
    @Override
    public void execute(String msg) {
        file.read();
        file.write(msg);
    }

    @Override
    public void undo() {
   file.undoWrite();

    }

}
