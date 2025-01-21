public class TypeLogger extends LoggerDecorator{

    private final String info;
    public TypeLogger(Logger logger,String info){
        super(logger);
        this.info=info;
    }

    @Override
    public void log(String msg){
        String ExtraInfomsg=msg+"------"+info+ " ";
        super.log(ExtraInfomsg);
    }
}
