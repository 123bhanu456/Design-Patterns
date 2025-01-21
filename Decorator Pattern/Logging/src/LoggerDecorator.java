public class LoggerDecorator implements Logger {

    protected Logger logger;
    public LoggerDecorator(Logger logger){
        this.logger=logger;
    }

    @Override
    public void log(String msg){
        logger.log(msg);
    }


}
