public class Controller {

    Command[] commands;
   NoCommand noCommand;
    Controller(){
        commands=new Command[3];
        for(int i=0;i<3;i++){
            commands[i]=noCommand;
        }
    }

    public void setCommand(int slot,Command command){
        commands[slot]=command;
    }

    public void pressButton(int slot,String msg){
        commands[slot].execute(msg);
    }

    public void pressUndo(int slot) {
        commands[slot].undo();
    }

}
