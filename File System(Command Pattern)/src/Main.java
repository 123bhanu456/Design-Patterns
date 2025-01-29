public class Main {
    public static void main(String[] args) {
        Controller remote=new Controller();
        FileFunction file=new FileFunction("Myfile.txt");

        ReadCommand read = new ReadCommand(file);
        WriteCommand write = new WriteCommand(file);
        ReadNWriteCommand readWrite = new ReadNWriteCommand(file);

        remote.setCommand(0,read);
        remote.setCommand(1,write);
        remote.setCommand(2,readWrite);

//       remote.pressButton(0,"");
//        remote.pressButton(1,"I'm good how are u?");
        remote.pressButton(2,"Now come to the real story");







    }
}
