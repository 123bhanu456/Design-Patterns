public class LevelLogger extends LoggerDecorator{


    int level;
    LevelLogger(Logger logger,int level) {
        super(logger);
        this.level=level;
    }

    @Override
    public void log(String msg){
        if(level==1)msg=msg+" -Info";
        if(level==2)msg=msg+" -Debug";
        if(level==3)msg=msg+" -Error";
        super.log(msg);
    }





}
